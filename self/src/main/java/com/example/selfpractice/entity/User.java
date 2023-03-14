package com.example.selfpractice.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "members")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id")
    private Long memberId;

    @Column(name = "id")
    private String id;
    @Column(name = "pw")
    private String pw;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "age")
    private int age;

    @Builder
    public User(String id, String pw, String phone, String address, int age) {
        this.id = id;
        this.pw = pw;
        this.phone = phone;
        this.address = address;
        this.age = age;
    }
}
