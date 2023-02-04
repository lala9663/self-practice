package com.example.springboot.board.dto;

import com.example.springboot.board.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
// 게시물 목록, 게시물 상세 조회에 필요한 필드
// Board Entity를 BoardResponseDto에 맞게 변환하는 생성자를 생성
public class BoardResponseDto {
    private Long id;
    private  String title;
    private String content;
    private int readCnt;
    private String registerId;
    private LocalDateTime registerTime;

    public BoardResponseDto(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.readCnt = entity.getReadCnt();
        this.registerId = entity.getRegisterId();
        this.registerTime = entity.getRegisterTime();
    }

    @Override
    public String toString() {
        return "BoardListDto [id=" + id + ", title=" + title + ", content=" + content + ", readCnt=" + readCnt +
                "registerId=" + registerId + ", registerTime=" + registerTime + "]";
    }
}
