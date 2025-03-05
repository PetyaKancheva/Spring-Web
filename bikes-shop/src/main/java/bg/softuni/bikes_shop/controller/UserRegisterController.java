package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.service.UserService;
import bg.softuni.bikes_shop.util.CurrentSessionMessage;
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
    private final CurrentSessionMessage currentSessionMessage;

    public UserRegisterController(UserService userService, CurrentSessionMessage currentSessionMessage) {
        this.userService = userService;
        this.currentSessionMessage = currentSessionMessage;
    }

    @GetMapping("/register")
    private String register(Model model){

        if (!model.containsAttribute("userRegisterDTO")) {
            model.addAttribute("userRegisterDTO", UserRegisterDTO.empty());
        }
        currentSessionMessage.setSuccessfullyRegistered(false);
        return "user-register";

    }
    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult, RedirectAttributes rAtt) {

        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("userRegisterDTO",userRegisterDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);
            return "user-register";
        }

        //TODO: Registration email with activation link
        userService.register(userRegisterDTO);
        currentSessionMessage.setSuccessfullyRegistered(true);
        return "user-register";
    }


}
