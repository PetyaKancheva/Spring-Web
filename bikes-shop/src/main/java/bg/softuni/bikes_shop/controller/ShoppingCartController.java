package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.service.OrderService;
import bg.softuni.bikes_shop.util.CurrentOrder;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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

        return "redirect:shopping-cart";
    }

    @DeleteMapping("/shopping-cart")
    public String delete( String  productID){
        //  TODO validate if product ID exists
//            currentOrder.deleteItem(Long.valueOf(productID));

        return "redirect:/shopping-cart";
    }
    @GetMapping("/shopping-cart-finalize")
    public String finalizePurchase(){
            String fakeEmail="";
//            TODO FIX logic? why it is GET not POST??
        if (currentOrder.getItems()!=null ){

            orderService.buy(fakeEmail,currentOrder.getItems(),currentOrder.getTotalPrice());
            currentOrder.clear();
        }


        return  "shopping-cart";
    }


    }




