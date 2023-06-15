package com.example.selfpractice.controller;

import com.example.selfpractice.dto.LoginRequestDTO;
import com.example.selfpractice.dto.SignupRequestDTO;
import com.example.selfpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public String signup(SignupRequestDTO signupRequestDTO) {
        return userService.signup(signupRequestDTO);
    }

    @PostMapping("/login")
    public String login(LoginRequestDTO loginRequestDTO) {
        return userService.login(loginRequestDTO);
    }
}
