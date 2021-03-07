package com.hyoseon.board.main.controller;

import javax.servlet.http.HttpServletRequest;

import com.hyoseon.board.main.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post/delete")
public class DeleteController {

    @Autowired
    private PostService PostService;

    @PostMapping
    @CrossOrigin
    public int deletePost(
        @RequestParam("postidx") int postidx,
        @RequestParam("password") int postPassword,
        HttpServletRequest request
    ){


        return PostService.deletePost(postidx, postPassword, request);
    }
    

    
}
