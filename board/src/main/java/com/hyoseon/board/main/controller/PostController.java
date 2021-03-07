package com.hyoseon.board.main.controller;

import com.hyoseon.board.main.service.PostService;
import com.hyoseon.board.main.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/post")
@Controller
public class PostController {

    // 글 READ, UPDATE, DELETE


    @Autowired
    private PostService postService;

    // READ
    @RequestMapping(method = RequestMethod.GET)
    public String readPost(
        @RequestParam("postidx") int postidx,
        Model model
    ){
        
        Board board = postService.readPost(postidx);
        model.addAttribute("board", board);

        
        
        return "post/view";
    }
    
}
