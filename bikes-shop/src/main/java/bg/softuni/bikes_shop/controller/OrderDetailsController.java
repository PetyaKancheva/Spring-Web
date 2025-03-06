package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.dto.ProductDTO;
import bg.softuni.bikes_shop.util.CurrentOrder;
import bg.softuni.bikes_shop.util.TestUser;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderDetailsController {
    private final CurrentOrder currentOrder;
    private final TestUser testUser;

    public OrderDetailsController(CurrentOrder currentOrder, TestUser testUser) {
        this.currentOrder = currentOrder;
        this.testUser = testUser;
    }

    @GetMapping("/order")
    public String order(Model model){
        if (!testUser.getLogged()) {
            return "redirect:/login";
        }
//
//        currentOrder.setProductId((long)111);
//        currentOrder.setProductName("222");
//        model.addAttribute(currentOrder);
        // add attribute current order or not?
        return "order-details";
    }
    @PostMapping("/order")
    public String buy(@PathVariable("id") String id, ProductDTO productDTO) {
        if (!testUser.getLogged()) {
            return "redirect:/login";
        }

        currentOrder.setProductId(productDTO.id());
        currentOrder.setProductName(productDTO.name());
        currentOrder.setQuantity(1);

        return "order-details";
    }


}
