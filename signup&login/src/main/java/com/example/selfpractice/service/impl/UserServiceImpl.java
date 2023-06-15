package com.example.selfpractice.service.impl;

import com.example.selfpractice.dto.LoginRequestDTO;
import com.example.selfpractice.dto.SignupRequestDTO;
import com.example.selfpractice.entity.User;
import com.example.selfpractice.repository.UserRepository;
import com.example.selfpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public String signup(SignupRequestDTO signupRequestDTO) {
        if (userRepository.findById(signupRequestDTO.getId()).isEmpty()) {
            User id = userRepository.save(signupRequestDTO.toEntity());
            return "회원 가입 성공";
        } else {
            if (!userRepository.findById(signupRequestDTO.getId()).isEmpty()) {
                return "이미 존재하는 아이디입니다.";
            }
        }
        return "회원가입 성공";
    }



    public String login(LoginRequestDTO loginRequestDTO) {
        Optional<User> user = userRepository.findById(loginRequestDTO.getId());
        Optional<User> user1 = userRepository.findByPw(loginRequestDTO.getPw());
        if (user.equals(loginRequestDTO.getId())) {
            if (user1.equals(loginRequestDTO.getPw())) {
                return "로그인 성공";
            } else {
                return "비밀번호 틀림";
            }
        } else {
            return "해당 아이디 없음";
        }
    }

    public List<User> findMembers() {
        return userRepository.findAll();
    }

    public Optional<User> findId(String id) {
        return userRepository.findById(id);
    }



}
