package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.DTO.UserLoginDTO;
import bg.softuni.pathfinder.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "login";
    }

    @PostMapping("/users/login")
    public String login (UserLoginDTO userLoginDTO ){

        userService.loginUser(userLoginDTO);
            return "redirect:/";
        }
    }


