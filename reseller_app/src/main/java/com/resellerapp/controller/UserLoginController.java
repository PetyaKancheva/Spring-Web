package com.resellerapp.controller;

import com.resellerapp.model.LoginDTO;
import com.resellerapp.service.LoggedUser;
import com.resellerapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/users")
@Controller
public class UserLoginController {
    private final UserService userService;
    private final LoggedUser loggedUser;

    public UserLoginController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/login")
    public ModelAndView login(Model model) {
        if (!model.containsAttribute("loginDTO")){
            model.addAttribute("loginDTO", new LoginDTO());
        }

        return new ModelAndView("login");
    }

    @GetMapping("/")
    public ModelAndView index() {

        return new ModelAndView("index");
    }

    @PostMapping("/login")
    public ModelAndView login(LoginDTO loginDTO) {

        userService.login(loginDTO);
        loggedUser.isLogged();


        return new ModelAndView("home");

    }


}
