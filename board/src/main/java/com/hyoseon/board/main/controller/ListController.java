package com.hyoseon.board.main.controller;
import java.util.List;

import com.google.gson.Gson;
import com.hyoseon.board.main.service.ListService;
import com.hyoseon.board.main.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/list")
public class ListController {
	// 리스트출력    

	
	@Autowired
	private ListService listService;

		
	/* 전체 게시글 */
	@GetMapping
	public String allList()  {
		String json="";
		List<Board> data = listService.getList();

		Board boardVO = new Board();
		boardVO.setData(data);

		json = new Gson().toJson(data);
		json = "{\"data\":" + json + "}";

		return json;
	}

}
