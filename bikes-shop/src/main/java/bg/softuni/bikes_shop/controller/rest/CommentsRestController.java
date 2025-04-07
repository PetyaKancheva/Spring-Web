package bg.softuni.bikes_shop.controller.rest;

import bg.softuni.bikes_shop.model.dto.CommentDTO;
import bg.softuni.bikes_shop.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CommentsRestController {
    private final RestTemplate restTemplate;
    private final CommentService commentService;

    public CommentsRestController(RestTemplate restTemplate, CommentService commentService) {
        this.restTemplate = restTemplate;
        this.commentService = commentService;
    }

    // add error handling
    @GetMapping("/api/comment/{id}")
    public CommentDTO getOneComment(@PathVariable("id") Long id) {
        Map<String, Long> requestPram = Map.of("id", id);
        return restTemplate.getForObject(commentService.getURLForOneComment(id), CommentDTO.class, requestPram);
    }
    @GetMapping(value = "/api/comments/fetch", produces = "application/json")
    public Object fetchAllComments() {
        return restTemplate.getForEntity(commentService.getURLForAllComments(), Object[].class);
    }

    @PostMapping("/api/comment/add")
    public CommentDTO post(@Valid CommentDTO commentDTO) {

        return restTemplate.postForObject(commentService.getURLForCommentAddition(), commentDTO, CommentDTO.class);
    }

    @GetMapping("/api/comment/delete/{id}")
    public void delete(@PathVariable("id") Long id) {

        restTemplate.delete(commentService.getURLForCommentDeletion(id), id);
    }


}

