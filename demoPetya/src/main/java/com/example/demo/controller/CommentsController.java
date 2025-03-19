package com.example.demo.controller;


import com.example.demo.model.CommentEntity;
import com.example.demo.repo.CommentsRepository;
import com.example.demo.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CommentsController {

    private final CommentService commentService;
    private final CommentsRepository commentsRepository;
    public CommentsController(CommentService commentService, CommentsRepository commentsRepository) {

        this.commentService = commentService;
        this.commentsRepository = commentsRepository;
    }
    @GetMapping("/comments")
    public String comments( Model model ,  @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,@RequestParam("sort") Optional<Integer>n){

            int currentPage = page.orElse(0);
            int pageSize = size.orElse(3);
            int sort=n.orElse(1);
            String pageSort="";
        if(sort == 1){
            pageSort="id";
        }else if(sort==2) {
            pageSort="title";
        }



       Page<CommentEntity> commentPage=  commentsRepository.findAll(PageRequest.of(currentPage,pageSize, Sort.by(pageSort)));

        model.addAttribute("comments",commentPage);


        return "comments";
    }
    @PostMapping("/comments")
    public String postMethod(Optional<Integer>n, RedirectAttributes rAtt){

        System.out.println(n);
     return "/comments";
    }


}
