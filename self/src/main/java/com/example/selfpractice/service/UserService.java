package com.example.selfpractice.service;

import com.example.selfpractice.dto.LoginRequestDTO;
import com.example.selfpractice.dto.SignupRequestDTO;

public interface UserService {

    public String signup(SignupRequestDTO signupRequestDTO);

    public String login(LoginRequestDTO loginRequestDTO);
}
