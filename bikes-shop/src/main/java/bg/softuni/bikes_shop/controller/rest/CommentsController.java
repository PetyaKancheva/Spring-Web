package bg.softuni.bikes_shop.controller.rest;

import bg.softuni.bikes_shop.model.dto.CommentDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class CommentsController{
    private final RestTemplate restTemplate;
    private final static String REST_URL_WITH_ID="https://jsonplaceholder.typicode.com/posts/{id}";
    private final static String REST_URL="https://jsonplaceholder.typicode.com/posts/";


    public CommentsController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/comment/{id}")
    public CommentDTO getOneComment(@PathVariable("id")Long id   ){
        Map<String, Long> requestPram= Map.of("id",id);
        return restTemplate.getForObject(REST_URL_WITH_ID,CommentDTO.class,requestPram);
    }
    @GetMapping("/comments")
    public ResponseEntity<Object[]> getAll( ){

        return restTemplate.getForEntity(REST_URL,Object[].class);
    }
//
//    @PostMapping("/comment/add")
//    public CommentDTO post(CommentDTO commentDTO){
//        CommentDTO newComment= new CommentDTO();
//        newComment.setBody("This bike is the best!");
//        newComment.setId(111l);
//        newComment.setTitle("New Comment");
//        newComment.setUserId(1l);
//        return restTemplate.postForObject(REST_URL,newComment,CommentDTO.class);
//    }
    //    @DeleteMapping("/comment/delete")
//    public CommentDTO post(Long id ){
//        CommentDTO newComment= new CommentDTO();
//        newComment.setBody("This bike is the best!");
//        newComment.setId(111l);
//        newComment.setTitle("New Comment");
//        newComment.setUserId(1l);
//        return restTemplate.delete(REST_URL,newComment,CommentDTO.class);
//    }


}

