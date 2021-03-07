package com.hyoseon.board.main.controller;

import javax.servlet.http.HttpServletRequest;

import com.hyoseon.board.main.service.WriteService;
import com.hyoseon.board.main.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/post/write")
public class WriteController {

	@Autowired
	private WriteService service;


    // 글쓰기 페이지로 보내기
    @RequestMapping(method = RequestMethod.GET)
    public String writeForm() {
        return "post/writeForm";
    }

    // 글등록하기
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody int write(
        @ModelAttribute("board") Board board,
        HttpServletRequest request
    ) {
		
		System.out.println(board);
		int result = service.writePost(board, request);
;
        return result;
    }

}
