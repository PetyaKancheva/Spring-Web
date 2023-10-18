package org.softuni.mobilele.web;

import jakarta.validation.Valid;
import org.softuni.mobilele.model.dto.UserLoginDTO;
import org.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login(Model model){
        if(!model.containsAttribute("userLoginDTO")){
            model.addAttribute("userLoginDTO",UserLoginDTO.empty());
        }

        return "auth-login";
    }




    @PostMapping("/users/login")
    public String login(@Valid  UserLoginDTO userLoginDTO, BindingResult bindingResult, RedirectAttributes rAtt) {

        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("userLoginDTO", userLoginDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO", bindingResult);
            return "redirect:/users/login";
        }

        if(!userService.login(userLoginDTO)){
            rAtt.addFlashAttribute("loginUnsuccessful",true);
            return "redirect:/users/login";
        }
            return "redirect:/";

    }
    @GetMapping("/users/logout")
    public String logout() {
        userService.logout();
        return "index";
    }


}
