package org.softuni.mobilele.web;

import jakarta.validation.Valid;
import org.softuni.mobilele.model.dto.UserLoginDTO;
import org.softuni.mobilele.service.UserService;
import org.softuni.mobilele.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@RequestMapping("/users")
@Controller
public class UserLoginController {

    private final UserService userService;
    private final CurrentUser currentUser;

    public UserLoginController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @GetMapping("/login")
    public String login(Model model){
        if(!model.containsAttribute("userLoginDTO")){
            model.addAttribute("userLoginDTO",UserLoginDTO.empty());
        }

        return "auth-login";
    }




    @PostMapping("/login")
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
    @PostMapping("/logout")
    public ModelAndView logout() {
        if(!currentUser.isLogged()){
            return new ModelAndView(("redirect:/users/login"));
        }
        userService.logout();
        return new ModelAndView("redirect:/");
    }




}
