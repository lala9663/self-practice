package com.example.redis.v1.controller;


import com.example.redis.lib.Helper;
import com.example.redis.v1.dto.ResponseDto;
import com.example.redis.v1.dto.request.MemberRequestDto;
import com.example.redis.v1.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.redis.v1.dto.ResponseDto.success;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {


    private final MemberService memberService;
    @PostMapping("/members")
    public ResponseDto<?> signUp(@Validated @RequestBody MemberRequestDto.SignUp signUp, Errors errors) {
        // validation check
        if (errors.hasErrors()) {
            return new ResponseDto<>(Helper.refineErrors(errors));
        }
        return memberService.signUp(signUp);
    }

    @PostMapping("/login")
    public ResponseDto<?> login(@Validated @RequestBody MemberRequestDto.Login login, Errors errors) {
        // validation check
        if (errors.hasErrors()) {
            return new ResponseDto<>(Helper.refineErrors(errors));
        }
        return memberService.login(login);
    }

    @PostMapping("/reissue")
    public ResponseDto<?> reissue(@Validated @RequestBody MemberRequestDto.Reissue reissue, Errors errors) {
        // validation check
        if (errors.hasErrors()) {
            return new ResponseDto<>(Helper.refineErrors(errors));
        }
        return memberService.reissue(reissue);
    }

    @PostMapping("/logout")
    public ResponseDto<? extends Object> logout(@Validated @RequestBody MemberRequestDto.Logout logout, Errors errors) {
        // validation check
        if (errors.hasErrors()) {
            return new ResponseDto<>(Helper.refineErrors(errors));
        }
        return memberService.logout(logout);
    }

    @GetMapping("/authority")
    public ResponseDto<?> authority() {
        log.info("ADD ROLE_ADMIN");
        return memberService.authority();
    }

    @GetMapping("/userTest")
    public ResponseDto<?> userTest() {
        log.info("ROLE_USER TEST");
        return new ResponseDto<>(success());
    }

    @GetMapping("/adminTest")
    public ResponseDto<?> adminTest() {
        log.info("ROLE_ADMIN TEST");
        return new ResponseDto<>(success());
    }
}
