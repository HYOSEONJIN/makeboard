package com.hyoseon.board.main.controller;
import java.util.List;


import com.hyoseon.board.main.service.ListService;
import com.hyoseon.board.main.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/list")
public class ListController {
    

	
	@Autowired
	private ListService listService;

		
	/* 전체 게시글 리스트 형식으로 보내주기 */
	@GetMapping
	public List<Board> allList()  {
		return listService.getList();	
	}

}
