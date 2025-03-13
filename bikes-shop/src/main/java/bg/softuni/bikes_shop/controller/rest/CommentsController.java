package bg.softuni.bikes_shop.controller.rest;

import bg.softuni.bikes_shop.model.dto.CommentDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CommentsController {
    private final RestTemplate restTemplate;

    public CommentsController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/comments")
    public String getAll(Model model){

//            String thisURL="http://localhost:6363/";
            String thisURL="https://jsonplaceholder.typicode.com/posts";
            // TODO fix all

        ResponseEntity<Object[]> rE= restTemplate.getForEntity(thisURL, Object[].class);

        Object[] objects = rE.getBody();


        model.addAttribute("allCommentDTO",objects);
        return "comments";
    }
}
