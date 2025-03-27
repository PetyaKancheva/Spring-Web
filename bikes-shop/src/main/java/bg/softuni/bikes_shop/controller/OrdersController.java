package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.CustomUserDetails;
import bg.softuni.bikes_shop.model.dto.OrderDTO;
import bg.softuni.bikes_shop.service.OrderService;
import bg.softuni.bikes_shop.util.CurrentOrder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrdersController {
    private final CurrentOrder currentOrder;
    private final OrderService orderService;

    public OrdersController(CurrentOrder currentOrder, OrderService orderService) {
        this.currentOrder = currentOrder;
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String orders(@AuthenticationPrincipal CustomUserDetails currentUser, Model model) {

      model.addAttribute("allOrders", orderService.getAllByUser(currentUser.getUsername()));

        return "orders";
    }


}
