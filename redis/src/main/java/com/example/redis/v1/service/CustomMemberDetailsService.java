package com.example.redis.v1.service;


import com.example.redis.entity.Member;
import com.example.redis.v1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomMemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findByMemberEmail(username)
                .map(this::createMemberDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
    }

    // 해당하는 Member 의 데이터가 존재한다면 MemberDetails 객체로 만들어서 리턴
    private UserDetails createMemberDetails(Member member) {
        return new Member(member.getUsername(), member.getPassword(), member.getAuthorities());
    }
}
