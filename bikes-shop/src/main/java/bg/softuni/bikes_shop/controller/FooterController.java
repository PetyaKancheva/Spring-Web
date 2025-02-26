package bg.softuni.bikes_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// TODO check REst controller

@Controller
public class FooterController {

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
