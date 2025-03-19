package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.CustomUserDetails;
import bg.softuni.bikes_shop.model.dto.UserUpdateDTO;
import bg.softuni.bikes_shop.service.UserService;
import bg.softuni.bikes_shop.util.MyPublisher;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserProfileController {
    private final UserService userService;
    private final MyPublisher myPublisher;

    public UserProfileController(UserService userService, MyPublisher myPublisher) {
        this.userService = userService;
        this.myPublisher = myPublisher;
    }

    @GetMapping("/user")
    private String profile(@AuthenticationPrincipal CustomUserDetails currentUser, Model model) {
        if (!model.containsAttribute("userUpdateDTO")) {
            model.addAttribute("userUpdateDTO", UserUpdateDTO.empty());
        }
        model.addAttribute("currentUser", currentUser);
        myPublisher.publishEvent(currentUser.getFirstName());

        return "user-profile";
    }

    @PostMapping("/user")
    private String profile(@AuthenticationPrincipal CustomUserDetails currentUser, @Valid UserUpdateDTO userUpdateDTO, BindingResult bindingResult, RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("userUpdateDTO", userUpdateDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.userUpdateDTO", bindingResult);
            return "user-profile";
        }

        userService.update(userUpdateDTO, currentUser.getUsername());

        rAtt.addFlashAttribute("successfullyUpdated","Your profile is successfully updated!");

        return "redirect:/user";
    }


}
