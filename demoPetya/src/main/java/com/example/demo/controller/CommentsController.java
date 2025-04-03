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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
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
    public String comments( @RequestParam(defaultValue ="3") Integer s,
                            @RequestParam(defaultValue = "0") Integer p,
                            @RequestParam (defaultValue ="title: asc") String o,
                                                       Model model){
        String parameter=o.split(": ")[0];
       String direction=o.split(": ")[1];

      Sort.Order newOrder = new Sort.Order(Sort.Direction.fromString(direction),parameter);
//      Sort.Order newOrder = new Sort.Order(Sort.Direction.fromString("asc"),"title");

//?s=3&p=0&string=id:%20desc

       Page<CommentEntity> commentPage=  commentsRepository.findAll(PageRequest.of(p,s,Sort.by(newOrder)));
        System.out.println("page - " +commentPage.getTotalPages());
        System.out.println("size - " +commentPage.getSize());

        System.out.println("property is: " + commentPage.getSort());




        model.addAttribute("comments",commentPage);


        return "comments";
    }
    @PostMapping("/comments")
    public String postMethod(Optional<Integer>n, RedirectAttributes rAtt){

        System.out.println(n);
     return "/comments";
    }


}
