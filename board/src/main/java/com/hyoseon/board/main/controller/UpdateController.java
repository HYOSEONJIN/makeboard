package com.hyoseon.board.main.controller;

import javax.servlet.http.HttpServletRequest;

import com.hyoseon.board.main.service.PostService;
import com.hyoseon.board.main.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/post/update")
public class UpdateController {
    

    @Autowired
    private PostService postService;


    @RequestMapping(method = RequestMethod.GET)
    public String updateForm(
        @RequestParam("postidx") int postidx,
        Model model
    ){

        Board board = postService.readPost(postidx);
        model.addAttribute("board", board);
        System.out.println(board);

        return "post/updateForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String update(
        @ModelAttribute("board") Board board,
        HttpServletRequest request,
        Model model
    ){

        System.out.println(board);
        int result = postService.updatePost(board, request);
        model.addAttribute("result", result);

        return "post/updateResult";
    }

}
