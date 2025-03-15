package bg.softuni.bikes_shop.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

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
