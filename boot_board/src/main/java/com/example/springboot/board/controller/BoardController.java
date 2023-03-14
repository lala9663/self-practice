package com.example.springboot.board.controller;

import com.example.springboot.board.dto.BoardRequestDto;
import com.example.springboot.board.entity.Board;
import com.example.springboot.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import java.awt.print.Pageable;

@RequiredArgsConstructor
@Controller
// 목록,등록,상세 화면 패핑, 등록 액션 메서드를생성해주고, 목록에는 페이징 처리를 위한 파라미터를 받는다
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/list")
    public String getBoardListPage(Model model, @RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "5") Integer size)
            throws Exception {
        try {
            model.addAttribute("resultMap", boardService.findAll(page, size));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return "board/list";
    }


    @GetMapping("/board/write")
    public String getBoardWritePage(Model model, BoardRequestDto boardRequestDto) {
        return "board/write";
    }

    @GetMapping("/board/view")
    public String getBoardViewPage(Model model, BoardRequestDto boardRequestDto) throws Exception {
        try {
            if (boardRequestDto.getId() != null) {
                model.addAttribute("info", boardService.findById(boardRequestDto.getId()));
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return "/board/view";
    }

    @PostMapping("/board/write/action")
    public String boardWriteAction(Model model, BoardRequestDto boardRequestDto) throws Exception {
        try {
            Long result = boardService.save(boardRequestDto);

            if (result < 1) {
                throw new Exception("#Exception boardWriteAction!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return "redirect:board/list";
    }

    @PostMapping("/board/view/delete")
    public String boardViewDeleteAction(Model model, @RequestParam() Long id) throws Exception {
        try {
            boardService.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return "redirect:/board/list";
    }

    @PostMapping("/board/delete")
    public String boardDeleteAction(Model model, @RequestParam() Long[] deleteId) throws Exception {
        try {
            boardService.deleteAll(deleteId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return "redirect:/board/list";
    }

}
