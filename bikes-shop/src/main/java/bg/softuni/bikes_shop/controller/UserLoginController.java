package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {
    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    private String login(){

        return "user-login";

    }
    @PostMapping("/login-error")
    public String loginError(@ModelAttribute("email")String email,Model model) {
//        model.addAttribute("email",email);
//        model.addAttribute("bad_credentials", "true");
        //TODO decide what to happen on error

        return "user-login";
    }


}
