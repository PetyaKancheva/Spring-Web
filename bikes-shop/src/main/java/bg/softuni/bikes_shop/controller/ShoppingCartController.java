package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.dto.ItemDTO;
import bg.softuni.bikes_shop.service.OrderService;
import bg.softuni.bikes_shop.util.CurrentOrder;
import bg.softuni.bikes_shop.util.TestUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class ShoppingCartController {
    private final OrderService orderService;
    private final CurrentOrder currentOrder;
    private final TestUser testUser;

    public ShoppingCartController(OrderService orderService, CurrentOrder currentOrder, TestUser testUser) {
        this.orderService = orderService;
        this.currentOrder = currentOrder;
        this.testUser = testUser;
    }

    @GetMapping("/shopping-cart")
    public String cart(Model model){
//        if (!testUser.getLogged()) {
//            return "redirect:/login";
//        }
            // TODO fix refresh adds new product
        return "shopping-cart";
    }

    @PostMapping("/shopping-cart")
    public String delete(String  productID){

            currentOrder.deleteItem(Long.valueOf(productID));

        return "redirect:/shopping-cart";
    }
    @GetMapping("/shopping-cart-finalize")
    public String clear(){

        if (currentOrder.getItems()!=null ){

            orderService.buy(testUser.getEmail(),currentOrder.getItems(),currentOrder.getTotalPrice());
            currentOrder.clear();
        }


        return  "shopping-cart";
    }


    }




