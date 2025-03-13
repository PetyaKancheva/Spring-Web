package bg.softuni.comments_project.controller;

import bg.softuni.comments_project.service.CommentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private final CommentService commentService;

    public HomeController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public String home(Model model){
        model.addAttribute("comments",commentService.getAll());
        return "comments";
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String allComments() throws JsonProcessingException {
       String response =new ObjectMapper().writeValueAsString(  commentService.findById((long)1).orElse(null));
        System.out.println(response);

        return response ;
    }
}
