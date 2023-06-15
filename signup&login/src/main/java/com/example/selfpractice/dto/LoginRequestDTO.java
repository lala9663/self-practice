package com.example.selfpractice.dto;

import com.example.selfpractice.entity.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoginRequestDTO {
    private String id;
    private String pw;

    public User toEntity() {
        return User.builder()
                .id(this.id)
                .pw(this.pw)
                .build();
    }

}
