package com.example.springboot.board.entity;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// Entity 정의
// 테이블의 모든 필드와 Builder 생성자를 구현
// 혹시 테이블명이 Class명과 다를 경우 @Entity(name="테이블명")을 설정한다.
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private int readCnt;
    private String registerId;



    @Builder
    public Board(Long id, String title, String content, int readCnt, String registerId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.readCnt = readCnt;
        this.registerId = registerId;
    }
}
