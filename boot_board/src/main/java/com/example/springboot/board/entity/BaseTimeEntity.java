package com.example.springboot.board.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
// 공통적으로 사용될 날짜 필드를 관리할 클래스
// 꼭 날자가 아니더라도 공통적으로 반복되는 필드를 정의하여 사용해도 된다.
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime registerTime;
    @LastModifiedDate
    private LocalDateTime updateTime;
}
