package com.board.fullstack.controller;

import com.board.fullstack.domain.ResultVO;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @PostMapping("/hello3") // 받아들이는 url 경로를 의미
    public String Hello(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @PostMapping("/hello5")
    public ResultVO hello5(@RequestParam("name") String name) {
        ResultVO result = new ResultVO(0, name);
        return result;
    }

    @PostMapping("/hello6")
    public ResultVO hello6(@RequestBody ResultVO result) {
        return result;
    }
}
