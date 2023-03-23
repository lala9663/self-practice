package com.example.redis.v1.service;

import com.example.redis.entity.Hobby;
import com.example.redis.entity.Member;
import com.example.redis.enums.Authority;
import com.example.redis.jwt.JwtTokenProvider;
import com.example.redis.security.SecurityUtil;
import com.example.redis.v1.dto.ResponseDto;
import com.example.redis.v1.dto.request.MemberRequestDto;
import com.example.redis.v1.dto.response.MemberResponseDto;
import com.example.redis.v1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final RedisTemplate redisTemplate;

    public ResponseDto<?> signUp(MemberRequestDto.SignUp signUp) {
        if (memberRepository.existsByMemberEmail(signUp.getMemberEmail())) {
            return new ResponseDto<>("이미 회원가입된 이메일입니다.");
        }

        Member member = Member.builder()
                .memberEmail(signUp.getMemberEmail())
                .memberPassword(passwordEncoder.encode(signUp.getMemberPassword()))
                .memberName(signUp.getMemberName())
                .memberNickname(signUp.getMemberNickname())
                .memberPhone(signUp.getMemberPhone())
                .memberBirthDate(signUp.getMemberBirthDate())
                .memberHobby(Hobby.valueOf(signUp.getMemberHobby()))
                .roles(Collections.singletonList(Authority.ROLE_USER.name()))
                .build();
        memberRepository.save(member);

        return new ResponseDto<>("회원가입 성공했습니다.");
    }

    public ResponseDto<?> login(MemberRequestDto.Login login) {
        System.out.println("1아이디: " + login.getMemberEmail() + "비밀번호:" + login.getMemberPassword());
        if (memberRepository.findByMemberEmail(login.getMemberEmail()).orElse(null) == null) {
            return new ResponseDto<>("가입된 이메일이 아닙니다.");
        }

        UsernamePasswordAuthenticationToken authenticationToken = login.toAuthentication();

        System.out.println("2아이디: " + login.getMemberEmail() + "비밀번호:" + login.getMemberPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        System.out.println("authentication = " + authentication);
        System.out.println("3아이디: " + login.getMemberEmail() + "비밀번호:" + login.getMemberPassword());

        System.out.println(login.getMemberPassword());

        MemberResponseDto.TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);
        redisTemplate.opsForValue()
                .set("RT:" + authentication.getName(), tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime(), TimeUnit.MILLISECONDS);

        return new ResponseDto<>(tokenInfo);
    }

    public ResponseDto<?> reissue(MemberRequestDto.Reissue reissue) {
        // 1. Refresh Token 검증
        if (!jwtTokenProvider.validateToken(reissue.getRefreshToken())) {
            return new ResponseDto<>("Refresh Token 정보가 유효하지 않습니다.");
        }

        // 2. Access Token 에서 User email 을 가져옵니다.
        Authentication authentication = jwtTokenProvider.getAuthentication(reissue.getAccessToken());

        // 3. Redis 에서 User email 을 기반으로 저장된 Refresh Token 값을 가져옵니다.
        String refreshToken = (String)redisTemplate.opsForValue().get("회원:" + authentication.getName());
        // (추가) 로그아웃되어 Redis 에 RefreshToken 이 존재하지 않는 경우 처리
        if(ObjectUtils.isEmpty(refreshToken)) {
            return new ResponseDto<>("잘못된 요청입니다.");
        }
        if(!refreshToken.equals(reissue.getRefreshToken())) {
            return new ResponseDto<>("Refresh Token 정보가 일치하지 않습니다.");
        }

        // 4. 새로운 토큰 생성
        MemberResponseDto.TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

        // 5. RefreshToken Redis 업데이트
        redisTemplate.opsForValue()
                .set("RT:" + authentication.getName(), tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime(), TimeUnit.MILLISECONDS);

//        return response.success(tokenInfo, "Token 정보가 갱신되었습니다.", HttpStatus.OK);
        return new ResponseDto<>(tokenInfo);

    }

    public ResponseDto<?> logout(MemberRequestDto.Logout logout) {
        // 1. Access Token 검증
        if (!jwtTokenProvider.validateToken(logout.getAccessToken())) {
            return new ResponseDto<>("실패!");
        }

        // 2. Access Token 에서 User email 을 가져옵니다.
        Authentication authentication = jwtTokenProvider.getAuthentication(logout.getAccessToken());

        // 3. Redis 에서 해당 User email 로 저장된 Refresh Token 이 있는지 여부를 확인 후 있을 경우 삭제합니다.
        if (redisTemplate.opsForValue().get("RT:" + authentication.getName()) != null) {
            // Refresh Token 삭제
            redisTemplate.delete("RT:" + authentication.getName());
        }

        // 4. 해당 Access Token 유효시간 가지고 와서 BlackList 로 저장하기
        Long expiration = jwtTokenProvider.getExpiration(logout.getAccessToken());
        redisTemplate.opsForValue()
                .set(logout.getAccessToken(), "logout", expiration, TimeUnit.MILLISECONDS);

        return new ResponseDto<>("로그아웃 되었습니다.");
    }

    public ResponseDto<?> authority() {
        // SecurityContext에 담겨 있는 authentication userEamil 정보
        String memberEmail = SecurityUtil.getCurrentUserEmail();

        Member member = memberRepository.findByMemberEmail(memberEmail)
                .orElseThrow(() -> new UsernameNotFoundException("No authentication information."));

        // add ROLE_ADMIN
        member.getRoles().add(Authority.ROLE_ADMIN.name());
        memberRepository.save(member);

        return new ResponseDto<>(ResponseDto.success());
    }
}
