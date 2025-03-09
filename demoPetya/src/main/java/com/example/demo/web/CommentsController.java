package com.example.demo.web;

import com.example.demo.model.CommentDTO;
import com.example.demo.service.CommentService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class CommentsController {

    private final CommentService commentService;

    public CommentsController(CommentService commentService) {

        this.commentService = commentService;
    }

    @GetMapping("/api/comments/{id}")
    public String comments(@PathVariable("id")Long id, Model model){
       CommentDTO test= commentService.getComment(id);
        CommentDTO comment =new CommentDTO();
            model.addAttribute("comment", test);
            model.addAttribute("commentDTO", new CommentDTO());



        return "comments";
    }
    @PostMapping("/api/comments/{id}")
    public String create(CommentDTO commentDTO) {
            commentService.send(commentDTO);
        return "reload:/api/comments/{id}";
    }

}
