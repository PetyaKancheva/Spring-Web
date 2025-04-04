package bg.softuni.bikes_shop.controller.rest;

import bg.softuni.bikes_shop.model.dto.CommentDTO;
import bg.softuni.bikes_shop.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    @GetMapping("/comment/{id}")
    public CommentDTO getOneComment(@PathVariable("id") Long id) {
        Map<String, Long> requestPram = Map.of("id", id);
        return restTemplate.getForObject(commentService.getURLForOneComment(id), CommentDTO.class, requestPram);
    }

    @GetMapping("/comments")
    public ResponseEntity<Object[]> getAll() {

        return restTemplate.getForEntity(commentService.getURLForAllComments(), Object[].class);
    }
    @GetMapping("/comment/add")
    public CommentDTO getToCommentAdd()  {
        CommentDTO newComment = new CommentDTO(
               null ,"Petya", "This is my first comment", "This bike is the best!"      );

        return   restTemplate.postForObject(commentService.getURLForCommentAddition(),newComment, CommentDTO.class);
    }

//    @PostMapping("/comment/add")
//    public CommentDTO post() { // should be getting it from somewhere
/// / CSRF token
///
////        url, request, responseType
//// not working
//      return   restTemplate.postForObject(REST_URL_ADD_NEW,newComment, CommentDTO.class);
//    }

    @GetMapping("/comment/delete/{id}")
    public void delete(@PathVariable("id") Long id) {

         restTemplate.delete(commentService.getURLForCommentDeletion(id),id);
    }


}

