package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    private String allProducts(Model model){
        //get all products
        model.addAttribute("products",productService.getAllProducts());
        return "index";
    }


    //get all Categories

}




