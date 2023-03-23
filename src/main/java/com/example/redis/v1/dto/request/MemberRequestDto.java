package com.example.redis.v1.dto.request;


import com.example.redis.entity.Member;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class MemberRequestDto {

    @Getter
    @Setter
    public static class SignUp {
        @NotEmpty(message = "이메일은 필수 입력값입니다.")
        @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
        private String memberEmail;

        @NotEmpty(message = "비밀번호는 필수 입력값입니다.")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
        private String memberPassword;

        @NotEmpty(message = "성함을 적어주세요")
        private String memberName;

        @NotEmpty(message = "아이디를 적어주세요")
        @Size(min = 2, max = 10, message = "2글자 이상 10글자 이하로 입력해주세요")
        private String memberNickname;

        @NotEmpty(message = "휴대폰 번호를 작성해주세요")
        @Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", message = "000-0000-0000 으로 작성해주세요")
        private String memberPhone;

        @NotEmpty(message = "생일을 적어주세요")
        @Pattern(regexp = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$", message = "YYYY-MM-DD 으로 작성해주세요")
        private String memberBirthDate;

        @NotEmpty(message = "취미를 적어주세요")
        private String memberHobby;

//        public Member toEntity() {
//
//            return Member.builder()
//                    .memberEmail(this.memberEmail)
//                    .memberPassword(this.memberPassword)
//                    .memberName(this.memberName)
//                    .memberNickname(this.memberNickname)
//                    .memberPhone(this.memberPhone)
//                    .memberBirthDate(LocalDate.parse(this.memberBirthDate))
//                    .build();
//        }
    }

    @Getter
    @Setter
    public static class Login {
        @NotEmpty(message = "이메일은 필수 입력값입니다.")
        @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
        private String memberEmail;

        @NotEmpty(message = "비밀번호는 필수 입력값입니다.")
        private String memberPassword;
        public UsernamePasswordAuthenticationToken toAuthentication() {
            return new UsernamePasswordAuthenticationToken(memberEmail, memberPassword);
        }
    }

    @Getter
    @Setter
    public static class Reissue {
        @NotEmpty(message = "accessToken 을 입력해주세요.")
        private String accessToken;

        @NotEmpty(message = "refreshToken 을 입력해주세요.")
        private String refreshToken;
    }

    @Getter
    @Setter
    public static class Logout {
        @NotEmpty(message = "잘못된 요청입니다.")
        private String accessToken;

        @NotEmpty(message = "잘못된 요청입니다.")
        private String refreshToken;
    }

}
