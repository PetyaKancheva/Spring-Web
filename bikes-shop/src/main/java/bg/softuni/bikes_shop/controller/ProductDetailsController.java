package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.exceptions.ProductNotFoundException;
import bg.softuni.bikes_shop.model.dto.ProductDTO;
import bg.softuni.bikes_shop.service.ProductService;
import bg.softuni.bikes_shop.util.CurrentSessionMessage;
import bg.softuni.bikes_shop.util.TestUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductDetailsController {
    private final ProductService productService;
    private final CurrentSessionMessage currentSessionMessage;
    private final TestUser testUser;

    public ProductDetailsController(ProductService productService, CurrentSessionMessage currentSessionMessage, TestUser testUser) {
        this.productService = productService;
        this.currentSessionMessage = currentSessionMessage;
        this.testUser = testUser;
    }

    @GetMapping("/product/{id}")
    public String details(@PathVariable("id") String id, Model model) {

//        if (!currentUser.isLogged()) {
//            return new ModelAndView("redirect:/users/login");
//        }
            currentSessionMessage.setProductBought(false);
        ProductDTO singleProductDTO = productService.
                getSingleProduct(Long.parseLong(id))
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found!"));

        model.addAttribute("singleProduct", singleProductDTO);
        return "product-details";
    }

    @PostMapping("/product/{id}")
    public String buy(@PathVariable("id")String id, Long valueFromForm){
        // TODO check if id from link is same as model id????
        productService.buy(valueFromForm,testUser.getEmail());
        currentSessionMessage.setProductBought(true);
        return "product-details";
    }

}

