package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.service.UserService;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserLoginController {

    @GetMapping("/login")
    private String login() {
        return "user-login";
    }

    @PostMapping("/login-error")
    public String loginError(RedirectAttributes rAtt) {
        rAtt.addFlashAttribute("error", "Invalid username or password.");
        return "redirect:/login";
    }

}
