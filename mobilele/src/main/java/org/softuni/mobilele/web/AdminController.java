package org.softuni.mobilele.web;

import org.softuni.mobilele.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    private final CurrentUser currentUser;

    public AdminController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/user/update")
    private ModelAndView update (){
        if(!currentUser.isAdmin()){
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("user");
    }
}
