package com.hyoseon.board.main.controller;

import javax.servlet.http.HttpServletRequest;

import com.hyoseon.board.main.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/delete")
public class DeleteController {

    @Autowired
    private PostService PostService;

    @RequestMapping(method = RequestMethod.GET)
    public String deleteForm(
        @RequestParam("postidx") int postidx,
        Model model       
    ){

        model.addAttribute("postidx", postidx);

        return "post/delete";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView deletePost(
        @RequestParam("postidx") int postidx,
        @RequestParam("postPassword") String postPassword,
        HttpServletRequest request,
        Model model
    ){

        ModelAndView mav = new ModelAndView();


        int result = PostService.deletePost(postidx, postPassword, request);
        mav.addObject("result", result);
        mav.setViewName("post/deleteResult");

        return mav;
    }
    

    
}
