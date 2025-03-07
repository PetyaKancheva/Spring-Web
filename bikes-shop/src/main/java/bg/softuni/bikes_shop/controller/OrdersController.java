package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.dto.ItemDTO;
import bg.softuni.bikes_shop.model.dto.OrderDTO;
import bg.softuni.bikes_shop.service.OrderService;
import bg.softuni.bikes_shop.util.CurrentOrder;
import bg.softuni.bikes_shop.util.TestUser;
import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrdersController {
    private final CurrentOrder currentOrder;
    private final TestUser testUser;
    private final OrderService orderService;

    public OrdersController(CurrentOrder currentOrder, TestUser testUser, OrderService orderService) {
        this.currentOrder = currentOrder;
        this.testUser = testUser;
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String orders(Model model){
//        if (!testUser.getLogged()) {
//            return "redirect:/login";
//        }
        List<OrderDTO> allOrders=new ArrayList<>();

        if (currentOrder.getItems()!=null ){
            orderService.buy(testUser.getEmail(),currentOrder.getItems());

        }



        allOrders= orderService.getAllByUser(testUser.getEmail());


//            allOrders.add(new OrderDTO("ivan", null,2000.0));
//            allOrders.add(new OrderDTO("ivan", null,222000.0));

            model.addAttribute("allOrders", allOrders);
            // TODO fix refresh adds new product
        return "orders";
    }





}
