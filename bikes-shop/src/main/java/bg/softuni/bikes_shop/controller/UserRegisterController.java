package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@RequestMapping("/")
@Controller
public class UserRegisterController {

    @GetMapping("/register")
    private ModelAndView register(Model model){

        if (!model.containsAttribute("userRegisterDTO")) {
            model.addAttribute("userRegisterDTO", UserRegisterDTO.empty());
        }
        return new ModelAndView("user-register");

    }

}
