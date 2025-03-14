package bg.softuni.bikes_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AdminController {
    @GetMapping("/admin")
    private String viewProfile(Principal principal, Model model){
        model.addAttribute("principal",principal);
        return "admin-profile";
    }
}
