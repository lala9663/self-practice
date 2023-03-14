package com.example.springboot.board.repository;

import com.example.springboot.board.dto.BoardRequestDto;
import com.example.springboot.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;

// JpaRepository를 상속받아 CRUD의 기능을 담당하는 인터페이스
// @Query을 사용한 JPQL 방식의 updateBoard()메서드도 구현
public interface BoardRepository extends JpaRepository<Board, Long> {
    String UPDATE_BOARD = "UPDATE Board" +
            "SET TITLE = :#{#boardRequestDto.title}, " +
            "CONTENT = :#{#boardRequestDto.content}, " +
            "UPDATE_TIME = NOW() " +
            "WHERE ID = :#{#boardRequestDto.id}";

    String DELETE_BOARD = "DELETE FROM Board"
            + "WHERE ID IN (:deleteList)";

    @Transactional
    @Modifying
    @Query(value = UPDATE_BOARD, nativeQuery = true)
    public int updateBoard(@Param("boardRequestDto") BoardRequestDto boardRequestDto);

    @Transactional
    @Modifying
    @Query(value = DELETE_BOARD, nativeQuery = true)
    public int deleteBoard(@Param("deleteList") Long[] deleteList);
}
