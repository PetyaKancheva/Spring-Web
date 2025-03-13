package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.service.OrderService;
import bg.softuni.bikes_shop.util.CurrentOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShoppingCartController {
    private final OrderService orderService;
    private final CurrentOrder currentOrder;


    public ShoppingCartController(OrderService orderService, CurrentOrder currentOrder) {
        this.orderService = orderService;
        this.currentOrder = currentOrder;

    }

    @GetMapping("/shopping-cart")
    public String cart(Model model){
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
            String fakeEmail="";
//            TODO FIX
        if (currentOrder.getItems()!=null ){

            orderService.buy(fakeEmail,currentOrder.getItems(),currentOrder.getTotalPrice());
            currentOrder.clear();
        }


        return  "shopping-cart";
    }


    }




