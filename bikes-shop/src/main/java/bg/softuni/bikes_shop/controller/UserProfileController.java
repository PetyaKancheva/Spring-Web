package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.dto.UserUpdateDTO;
import bg.softuni.bikes_shop.service.UserService;
import bg.softuni.bikes_shop.util.CurrentSessionMessage;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserProfileController {
    private final UserService userService;

    private final CurrentSessionMessage currentSessionMessage;

    public UserProfileController(UserService userService,  CurrentSessionMessage currentSessionMessage) {
        this.userService = userService;

        this.currentSessionMessage = currentSessionMessage;
    }

    @GetMapping("/user")
    private String profile(Model model) {
        if(!model.containsAttribute("userUpdateDTO")){
            model.addAttribute("userUpdateDTO",UserUpdateDTO.empty());
        }
        currentSessionMessage.setSuccessfullyUpdatedUser(false);
        return "user-profile";
    }
     @PostMapping("/user")
     private String profile(@Valid UserUpdateDTO userUpdateDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addAttribute("userUpdateDTO",userUpdateDTO);
            redirectAttributes.addAttribute("org.springframework.validation.BindingResult.userUpdateDTO",bindingResult);
            return "user-profile";
        }
        String fakeEmail="p@mail.com";
        userService.update(userUpdateDTO,fakeEmail);
        currentSessionMessage.setSuccessfullyUpdatedUser(true);

        return "user-profile";

     }


}
