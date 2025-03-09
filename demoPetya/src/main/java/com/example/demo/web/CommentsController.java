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
    @GetMapping("/api/comments/")
    public String comments( Model model){

        List<CommentDTO> allComments= commentService.getAll();
        model.addAttribute("comments", allComments);
        model.addAttribute("commentDTO", new CommentDTO());

        return "comments";
    }

    @PostMapping("/api/comments/")
    public String create(CommentDTO commentDTO) {
            commentService.send(commentDTO);
        return "redirect:/api/comments/";
    }


}
