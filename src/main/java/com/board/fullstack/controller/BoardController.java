package com.board.fullstack.controller;

import com.board.fullstack.domain.BoardVO;
import com.board.fullstack.domain.ResultVO;
import com.board.fullstack.persistence.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BoardController {
    private final BoardMapper boardMapper;

    @PostMapping("/board")
    public ResultVO insert(@RequestBody BoardVO boardVO) {
        int result = boardMapper.insertBoard(boardVO);
        System.out.println(result);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @GetMapping("/board/{id}")
    public BoardVO findOne(@PathVariable int id) {
        return boardMapper.findOndBoard(id);
    }

    @GetMapping("/boards")
    public List<BoardVO> findAll(@RequestParam @Nullable Integer page_number,
                                @RequestParam @Nullable Integer page_size) {
        Integer offset = null;
        if (page_number != null && page_size != null) {
            offset = (page_number - 1) * page_size;
        }
        return boardMapper.findAllBoard(offset, page_size);
    }

    @GetMapping("board/count")
    public Integer countBoard() {
        return boardMapper.countBoard();
    }

    @PutMapping("/board")
    public ResultVO update(@RequestBody BoardVO boardVO) {
        int result = boardMapper.updateBoard(boardVO);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @DeleteMapping("/board")
    public ResultVO delete(@RequestParam int id) {
        int result = boardMapper.deleteBoard(id);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }
}
