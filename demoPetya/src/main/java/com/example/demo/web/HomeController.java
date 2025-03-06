package com.example.demo.web;

import com.example.demo.util.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
private final User user;
     private final String greeting;

     public HomeController(
             User user, @Value("${demo.greeting.message}")String greeting){
         this.user = user;
         this.greeting = greeting;
     }
    @GetMapping("/")
    public String test(Model model){
        model.addAttribute( "greeting","Hello there");
        return "index";

    }
    @PostMapping("/")
    public  String test(String fname,String lname){
        user.setFirstName(fname);
        user.setLastName(lname);
//        model.addAttribute("first",fname);
//        model.addAttribute("last",lname);

        return "page";
    }
}
