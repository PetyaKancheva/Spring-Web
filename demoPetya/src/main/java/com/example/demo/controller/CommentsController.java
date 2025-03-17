package com.example.demo.controller;


import com.example.demo.model.CommentEntity;
import com.example.demo.repo.CommentsRepository;
import com.example.demo.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String comments( Model model ,  @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){

            int currentPage = page.orElse(0);
            int pageSize = size.orElse(3);




       Page<CommentEntity> commentPage=  commentsRepository.findAll(PageRequest.of(currentPage,pageSize));

        model.addAttribute("comments",commentPage);
        return "comments";
    }



}
