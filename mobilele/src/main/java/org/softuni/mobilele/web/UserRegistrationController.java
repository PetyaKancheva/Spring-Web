package org.softuni.mobilele.web;

import org.softuni.mobilele.model.dto.UserRegistrationDTO;
import org.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegistrationController {

    private final UserService userService;


    public UserRegistrationController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/users/register")
    public String register() {
        return "auth-register";
    }
    @PostMapping("/users/register")
    public String register(UserRegistrationDTO userRegistrationDTO){
        userService.registerUser(userRegistrationDTO);

        return "redirect:/";
    }
    //TODO: Registration email with activation link
}
