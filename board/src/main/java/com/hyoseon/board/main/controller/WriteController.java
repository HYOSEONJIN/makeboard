package com.hyoseon.board.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/post/write")
public class WriteController {


    @RequestMapping(method = RequestMethod.GET)
	public String writeForm() {
		return "post/writeForm";
	}
	
    
}
