package bg.softuni.bikes_shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class testController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";


}}