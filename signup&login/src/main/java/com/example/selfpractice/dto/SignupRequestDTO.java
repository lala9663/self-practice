package com.example.selfpractice.dto;

import com.example.selfpractice.entity.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SignupRequestDTO {

    private String id;
    private String pw;
    private String phone;
    private String address;
    private int age;

    public User toEntity() {
        return User.builder()
                .id(this.id)
                .pw(this.pw)
                .phone(this.phone)
                .address(this.address)
                .age(this.age)
                .build();
    }
}
