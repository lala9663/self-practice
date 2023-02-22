package com.example.springboot.board.dto;

import com.example.springboot.board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
// 게시물 등록, 게시물 수정, 게미술 상세 조회에 필요한 필드
public class BoardRequestDto {
    private Long id;
    private String title;
    private String content;
    private String registerId;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .registerId(registerId)
                .build();
    }

}
