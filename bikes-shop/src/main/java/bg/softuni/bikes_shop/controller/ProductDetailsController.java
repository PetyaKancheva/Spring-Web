package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.exceptions.ProductNotFoundException;
import bg.softuni.bikes_shop.model.dto.ProductDTO;
import bg.softuni.bikes_shop.service.OrderService;
import bg.softuni.bikes_shop.service.ProductService;
import bg.softuni.bikes_shop.util.CurrentSessionMessage;
import bg.softuni.bikes_shop.util.TestUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductDetailsController {
    private final ProductService productService;
    private final OrderService orderService;
    private final CurrentSessionMessage currentSessionMessage;
    private final TestUser testUser;

    public ProductDetailsController(ProductService productService, OrderService orderService, CurrentSessionMessage currentSessionMessage, TestUser testUser) {
        this.productService = productService;
        this.orderService = orderService;
        this.currentSessionMessage = currentSessionMessage;
        this.testUser = testUser;
    }

    @GetMapping("/product/{id}")
    public String details(@PathVariable("id") String id, Model model) {
        currentSessionMessage.setProductBought(false);

        ProductDTO singleProductDTO = productService.
                getSingleProduct(Long.parseLong(id))
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found!"));

        model.addAttribute("singleProduct", singleProductDTO);
        model.addAttribute("quantity",0);
        return "product-details";
    }

    @PostMapping("/product/{id}")
    public String buy(@PathVariable("id") String id,  Integer quantity) {
        if (!testUser.getLogged()) {
            return "redirect:/login";
        }
//                if(bindingResult.hasErrors()){
//                    redirectAttributes.addFlashAttribute("productDTO",productDTO);
//                    redirectAttributes.addFlashAttribute("qustom message",quantity);
//                }

        orderService.buy(Long.valueOf(id), testUser.getEmail(), quantity);
        currentSessionMessage.setProductBought(true);
        return "product-details";
    }

}

