package bg.softuni.bikes_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";


}}