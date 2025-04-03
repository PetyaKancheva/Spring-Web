package bg.softuni.comments_project.controller;

import bg.softuni.comments_project.model.CommentDTO;
import bg.softuni.comments_project.model.CommentEntity;
import bg.softuni.comments_project.model.NewCommentDTO;
import bg.softuni.comments_project.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// three endpoints, get post, and delete
public class HomeController {
    private final CommentService commentService;

    public HomeController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAll(){


        return new ResponseEntity<>(commentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO>getByID(@PathVariable("id") String id){

        return  new  ResponseEntity<>(commentService.getById(id),HttpStatus.OK);
    }
    @PostMapping("/add_comment/")
    public NewCommentDTO addComment(@RequestBody NewCommentDTO newCommentDTO){

        return  commentService.addNewComment(newCommentDTO);

    }

    @DeleteMapping("/comment/{id}")
    void deleteComment(@PathVariable String id) {
//        repository.deleteById(id);
    }
}
