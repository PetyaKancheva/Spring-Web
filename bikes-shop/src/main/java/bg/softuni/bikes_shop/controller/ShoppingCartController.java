package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.dto.ItemDTO;
import bg.softuni.bikes_shop.util.CurrentOrder;
import bg.softuni.bikes_shop.util.TestUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
//        if (!testUser.getLogged()) {
//            return "redirect:/login";
//        }
            // TODO fix refresh adds new product
        return "shopping-cart";
    }

    @PostMapping("/shopping-cart")
    public String order(String  productID){

            currentOrder.delete(Long.valueOf(productID));

        return "redirect:/shopping-cart";
    }



}
