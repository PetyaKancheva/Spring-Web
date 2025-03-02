package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    private String allProducts(Model model){

        model.addAttribute("products",productService.getAllProducts());
        model.addAttribute("categories",productService.getDistinctCategories());
        return "index";
    }
}
