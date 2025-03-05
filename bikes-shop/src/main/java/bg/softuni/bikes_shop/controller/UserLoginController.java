package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.dto.UserLoginDTO;
import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.service.UserService;
import jakarta.validation.Valid;
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

    @GetMapping("/login")
    private String login(Model model){
        if (!model.containsAttribute("userLoginDTO")) {
            model.addAttribute("userLoginDTO", UserLoginDTO.empty());
        }
        return "user-login";

    }
    @PostMapping("/login")
    public String login(@Valid UserLoginDTO userLoginDTO  , BindingResult bindingResult, RedirectAttributes rAtt) {

        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("userLoginDTO",userLoginDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO", bindingResult);
            return "redirect:/login";
        }


        userService.login(userLoginDTO);
        return "redirect:/";
    }


}
