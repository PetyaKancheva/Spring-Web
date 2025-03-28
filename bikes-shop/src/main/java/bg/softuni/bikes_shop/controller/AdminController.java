package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.dto.AdminUpdateDTO;
import bg.softuni.bikes_shop.model.dto.ShortUserDTO;
import bg.softuni.bikes_shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.model.IModel;

import java.security.Principal;
import java.util.List;

@Controller
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    private String viewProfile(Principal principal, Model model) {

        model.addAttribute("principal", principal);
        model.addAttribute("adminUpdateDTO", AdminUpdateDTO.empty());

        return "admin-profile";
    }

    @PostMapping("/admin")
    private String search(String personToSearch, Model model) {

        List<ShortUserDTO> listOfPeople = userService.getByEmailFirstNameOrLastName(personToSearch);
        model.addAttribute("listPeople", listOfPeople);


        return "admin-profile";
    }

    @GetMapping("/admin/update/{id}")
    private String selectUser(@PathVariable("id") String email, Model model) {

        model.addAttribute("adminUpdateDTO", AdminUpdateDTO.empty());

    }

    @PostMapping("/admin/update")
    private String updateProfile() {


        System.out.println("post");

        return "admin-profile";
    }
}
