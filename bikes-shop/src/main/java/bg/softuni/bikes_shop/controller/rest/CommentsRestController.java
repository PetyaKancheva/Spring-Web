package bg.softuni.bikes_shop.controller.rest;

import bg.softuni.bikes_shop.model.dto.CommentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class CommentsRestController {
    private final RestTemplate restTemplate;
    private final static String REST_URL_WITH_ID = "http://localhost:6363/{id}";
    private final static String REST_URL_ALL = "http://localhost:6363/all";
    private final static String REST_URL_DELETE = "http://localhost:6363/delete_comment/{id}";
    private final static String REST_URL_ADD_NEW = "http://localhost:6363//add_comment/";


    public CommentsRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/comment/{id}")
    public CommentDTO getOneComment(@PathVariable("id") Long id) {
        Map<String, Long> requestPram = Map.of("id", id);
        return restTemplate.getForObject(REST_URL_WITH_ID, CommentDTO.class, requestPram);
    }

    @GetMapping("/comments")
    public ResponseEntity<Object[]> getAll() {

        return restTemplate.getForEntity(REST_URL_ALL, Object[].class);
    }

    @GetMapping("/comment/add")
    public void post() {
        CommentDTO newComment = new CommentDTO(
                "Petya", "This is my first comment", "This bike is the best!"
        );
//        url, request, responseType
// not working
        restTemplate.postForLocation(REST_URL_ADD_NEW,newComment);
    }

    @GetMapping("/comment/delete/{id}")
    public void delete(@PathVariable("id") Long id) {

         restTemplate.delete(REST_URL_DELETE,id);
    }


}

