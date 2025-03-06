package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.util.CurrentOrder;
import bg.softuni.bikes_shop.util.TestUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingCartController {
    private final CurrentOrder currentOrder;
    private final TestUser testUser;

    public ShoppingCartController(CurrentOrder currentOrder, TestUser testUser) {
        this.currentOrder = currentOrder;
        this.testUser = testUser;
    }

    @GetMapping("/shopping-cart")
    public String order(Model model){
        if (!testUser.getLogged()) {
            return "redirect:/login";
        }

       // current order is there

        return "shopping-cart";
    }



}
