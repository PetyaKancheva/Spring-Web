package bg.softuni.bikeshop.web;

import bg.softuni.bikeshop.model.dto.RegisterUserDTO;

import bg.softuni.bikeshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public ModelAndView register(){

        return new ModelAndView("register");
    }
    @PostMapping("/register")
    public ModelAndView register(RegisterUserDTO registerUserDTO){

        boolean successfullyRegistered = userService.register(registerUserDTO);
        if(!successfullyRegistered){
            return new ModelAndView("register");
        }

        return new ModelAndView("/");
    }
}
