package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserRegisterController {
    private final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    private ModelAndView register(Model model){

        if (!model.containsAttribute("userRegisterDTO")) {
            model.addAttribute("userRegisterDTO", UserRegisterDTO.empty());
        }
        return new ModelAndView("user-register");

    }
    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult, RedirectAttributes rAtt) {

        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("userRegisterDTO",userRegisterDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);
            return "redirect:/register";
        }

        //TODO: Registration email with activation link
        userService.register(userRegisterDTO);
        return "welcome-register"; //TODO remove welcome register and go to login page with some statement
    }


}
