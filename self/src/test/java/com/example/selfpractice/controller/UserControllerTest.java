package com.example.selfpractice.controller;

import com.example.selfpractice.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class UserControllerTest {

    @Test
    @DisplayName("회원가입 테스트")
    void signup() {
        /*
        given
         */
        User user = User.builder()
                .id("lala")
                .pw("1234")
                .phone("010")
                .address("고덕")
                .age(13)
                .build();
        /*
        * when. then
        * */
        assertThat(user.getId()).isEqualTo("lala");
        assertThat(user.getPw()).isEqualTo("1234");
        assertThat(user.getPhone()).isEqualTo("010");
        assertThat(user.getAddress()).isEqualTo("고덕");
        assertThat(user.getAge()).isEqualTo(13);
    }

    @Test
    void login() {
        User user = User.builder()
                .id("lala")
                .pw("1234")
                .build();

        assertThat(user.getId()).isEqualTo("lala");
        assertThat(user.getPw()).isEqualTo("1235");
    }
}