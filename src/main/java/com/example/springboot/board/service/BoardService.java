package com.example.springboot.board.service;

        import com.example.springboot.board.dto.BoardRequestDto;
        import com.example.springboot.board.dto.BoardResponseDto;
        import com.example.springboot.board.entity.Board;
        import com.example.springboot.board.repository.BoardRepository;
        import lombok.RequiredArgsConstructor;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.awt.print.Pageable;
        import java.util.HashMap;
        import java.util.List;
        import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
// 게시판 기능을 담당할 Service 클래스(파일 및 페이징 처리)
// Spring Data JPA 에서는 페이징 처리를 위한 PageRequest 객체를 지원하므로 간단하게 페이징 처리를 할 수 있다.
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardRequestDto boardSaveDto) {
        return boardRepository.save(boardSaveDto.toEntity()).getId();
    }

    /*
    	트랜잭션에 readOnly=true 옵션을 주면 스프링 프레임워크가 하이버네이트 세션 플러시 모드를 MANUAL로 설정한다.
    	이렇게 하면 강제로 플러시를 호출하지 않는 한 플러시가 일어나지 않는다.
    	따라서 트랜잭션을 커밋하더라도 영속성 컨텍스트가 플러시 되지 않아서 엔티티의 등록, 수정, 삭제이 동작하지 않고,
    	또한 읽기 전용으로, 영속성 컨텍스트는 변경 감지를 위한 스냅샷을 보관하지 않으므로 성능이 향상된다.
    */
    @Transactional(readOnly = true)
    public HashMap < String, Object > findAll(Integer page, Integer size) {

        HashMap < String, Object > resultMap = new HashMap < String, Object > ();

        Page < Board > list = boardRepository.findAll(PageRequest.of(page, size));

        resultMap.put("list", list.stream().map(BoardResponseDto::new).collect(Collectors.toList()));
        resultMap.put("paging", list.getPageable());
        resultMap.put("totalCnt", list.getTotalElements());
        resultMap.put("totalPage", list.getTotalPages());

        return resultMap;
    }

    public BoardResponseDto findById(Long id) {
        return new BoardResponseDto(boardRepository.findById(id).get());
    }

    public int updateBoard(BoardRequestDto boardRequestDto) {
        return boardRepository.updateBoard(boardRequestDto);
    }

//    public int updateBoardReadCntInc(Long id) {
//        return boardRepository.updateBoardReadCntInc(id);
//    }

    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

}