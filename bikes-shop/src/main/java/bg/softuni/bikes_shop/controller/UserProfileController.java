package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.CustomUserDetails;
import bg.softuni.bikes_shop.model.dto.UserMainUpdateDTO;
import bg.softuni.bikes_shop.model.dto.UserSelfUpdateDTO;
import bg.softuni.bikes_shop.service.UserService;
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
    private final static String SUCCESSFUL_UPDATE_MSG =
            "Your profile is successfully updated!";
    private final static String ATTRIBUTE_MSG_NAME="onSuccess";


    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")

    private String profile(@AuthenticationPrincipal CustomUserDetails currentUser, Model model) {

        if (!model.containsAttribute("mainUpdateDTO")) {
            model.addAttribute("mainUpdateDTO", userService.getUserMainUpdateDTO(currentUser.getEmail()));
        }
        if (!model.containsAttribute("selfUpdateDTO")) {
            model.addAttribute("selfUpdateDTO", UserSelfUpdateDTO.empty());
        }
        model.addAttribute("currentUser", currentUser);

        return "user-profile";
    }

    @PostMapping("/user")
    private String profile(@AuthenticationPrincipal CustomUserDetails currentUser,
                           @Valid UserMainUpdateDTO userMainUpdateDTO,@Valid UserSelfUpdateDTO userSelfUpdateDTO,
                           BindingResult bindingResult, RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("mainUpdateDTO", userMainUpdateDTO);
            rAtt.addFlashAttribute("selfUpdateDTO", userSelfUpdateDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.userUpdateDTO", bindingResult);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.selfUpdateDTO", bindingResult);
            return "redirect:/user";
        }

        userService.updateByUser(userMainUpdateDTO, userSelfUpdateDTO,currentUser.getUsername());

        rAtt.addFlashAttribute(ATTRIBUTE_MSG_NAME,SUCCESSFUL_UPDATE_MSG );

        return "redirect:/login";
    }


}
