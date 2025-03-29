package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.dto.AdminUpdateDTO;
import bg.softuni.bikes_shop.model.dto.ShortUserDTO;
import bg.softuni.bikes_shop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class AdminController {
    private final UserService userService;
    private final static String SUCCESSFULLY_UPDATED_USER_MSG =
            "User %s is now updated!";
    private final static String ATTRIBUTE_MSG_NAME = "onSuccess";

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    private String view(Model model) {
        model.addAttribute("adminUpdateDTO", AdminUpdateDTO.empty());
        return "admin-profile";
    }

    @PostMapping("/admin")
    private String search(String personToSearch,Model model) {

        List<ShortUserDTO> listOfPeople = userService.getAllByEmailFirsOrLastName(personToSearch);
        model.addAttribute("listPeople", listOfPeople);
        model.addAttribute("adminUpdateDTO", AdminUpdateDTO.empty());
        return "admin-profile";
    }

    @GetMapping("/admin/update={id}")
    private String selectUser(@PathVariable("id") String email, Model model) {

        model.addAttribute("adminUpdateDTO",  userService.getAdminDTO(email));
        return "admin-profile";

    }

    @PostMapping("/admin/update={id}")
    private String updateProfile(@PathVariable("id") String email, @Valid AdminUpdateDTO adminUpdateDTO, BindingResult bindingResult, RedirectAttributes rAtt) {

        // save update
        // send email to the updated.


        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("adminUpdateDTO", adminUpdateDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.adminUpdateDTO", bindingResult);
            return "redirect:/admin";
        }

        System.out.println(adminUpdateDTO);
        System.out.println("post");
        rAtt.addFlashAttribute(ATTRIBUTE_MSG_NAME,String.format(SUCCESSFULLY_UPDATED_USER_MSG,adminUpdateDTO.firstName()));
        return "redirect:/admin";
    }
}
