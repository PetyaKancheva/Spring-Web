package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.dto.UserUpdateDTO;
import bg.softuni.bikes_shop.service.UserService;
import bg.softuni.bikes_shop.util.CurrentSessionMessage;
import bg.softuni.bikes_shop.util.TestUser;
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
    private final TestUser testUser;
    private final CurrentSessionMessage currentSessionMessage;

    public UserProfileController(UserService userService, TestUser testUser, CurrentSessionMessage currentSessionMessage) {
        this.userService = userService;
        this.testUser = testUser;
        this.currentSessionMessage = currentSessionMessage;
    }

    @GetMapping("/user")
    private String profile(Model model) {
        if(!model.containsAttribute("userUpdateDTO")){
            model.addAttribute("userUpdateDTO",UserUpdateDTO.empty());
        }
        return "user-profile";
    }
     @PostMapping("/user")
     private String profile(@Valid UserUpdateDTO userUpdateDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addAttribute("userUpdateDTO",userUpdateDTO);
            redirectAttributes.addAttribute("org.springframework.validation.BindingResult.userUpdateDTO",bindingResult);
            return "user-profile";
        }
        userService.update(userUpdateDTO,testUser.getEmail());
        currentSessionMessage.setSuccessfullyUpdatedUser(true);
//        update Testuser.
        return "user-profile";

     }


}
