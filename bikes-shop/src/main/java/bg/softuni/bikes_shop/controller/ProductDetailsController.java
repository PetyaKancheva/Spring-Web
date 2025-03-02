package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.exceptions.ProductNotFoundException;
import bg.softuni.bikes_shop.model.dto.ProductDTO;
import bg.softuni.bikes_shop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductDetailsController {
    private final ProductService productService;

    public ProductDetailsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public String singleProduct(@PathVariable("id") String id, Model model) {

//        if (!currentUser.isLogged()) {
//            return new ModelAndView("redirect:/users/login");
//        }
        ProductDTO singleProductDTO = productService.
                getSingleProduct(Long.parseLong(id))
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found!"));

        model.addAttribute("singleProduct", singleProductDTO);
        return "product-details";
    }

}

