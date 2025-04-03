package bg.softuni.comments_project.controller;

import bg.softuni.comments_project.model.CommentEntity;
import bg.softuni.comments_project.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
// three endpoints, get post, and delete
public class HomeController {
    private final CommentService commentService;

    public HomeController(CommentService commentService) {
        this.commentService = commentService;
    }

//    @GetMapping("/all")
//    public String home(Model model){
//        model.addAttribute("comments",commentService.getAll());
//        return "comments";
//    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentEntity>getByID(@PathVariable("id") Long id){

        return  new  ResponseEntity<>(commentService.getById(id),HttpStatus.OK);
    }

}
