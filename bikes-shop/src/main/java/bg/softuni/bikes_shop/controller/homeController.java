package bg.softuni.bikes_shop.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO check REst controller

@Controller
public class homeController {
    @GetMapping("/")
    private String index(){
        return "index";
    }
    @GetMapping("/about")
    private String about(){
        return "about";
    }
    @GetMapping("/services")
    private String services(){
        return "services";
    }
    @GetMapping("/contacts")
    private String contacts(){
        return "contacts";
    }

}
