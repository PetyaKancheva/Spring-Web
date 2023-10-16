package bg.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    private String index(){
        return "index";
    }

    @GetMapping("/about")
    private String about(){
        return "about";
    }

}
