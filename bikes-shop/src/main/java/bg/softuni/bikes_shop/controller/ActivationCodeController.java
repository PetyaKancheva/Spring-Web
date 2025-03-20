package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.service.UserActivationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActivationCodeController {
    private final UserActivationService userActivationService;

    public ActivationCodeController(UserActivationService userActivationService) {
        this.userActivationService = userActivationService;
    }

    @GetMapping ("/user/activate(activation_code={activationCode})")// better systaxis??
    private String activateUser(@RequestParam("activationCode") String activationCode){
        userActivationService.userActivate(activationCode);
// TODO not working
        return "user-login";
    }
}
