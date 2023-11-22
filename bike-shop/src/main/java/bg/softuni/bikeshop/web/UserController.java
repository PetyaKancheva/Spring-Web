package bg.softuni.bikeshop.web;

import bg.softuni.bikeshop.model.dto.LoginUserDTO;
import bg.softuni.bikeshop.model.dto.RegisterUserDTO;

import bg.softuni.bikeshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public ModelAndView register(Model model){
        if(!model.containsAttribute("registerUserDTO")){
            model.addAttribute("registerUserDTO", new RegisterUserDTO());
        }

        return new ModelAndView("register");
    }
    @PostMapping("/register")
    public ModelAndView register(RegisterUserDTO registerUserDTO){

        userService.register(registerUserDTO);

//        boolean successfullyRegistered =
//        if(!successfullyRegistered){
//            return new ModelAndView("register");
//        }

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/login")
    public ModelAndView login(Model model){
        if(!model.containsAttribute("loginUserDTO")){
            model.addAttribute("loginUserDTO",new LoginUserDTO());
        }
        return new ModelAndView("login");
    }
    @PostMapping("/login")
    public ModelAndView login(LoginUserDTO loginUserDTO){
        if(!userService.login(loginUserDTO)){
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("redirect:/");
    }

}
