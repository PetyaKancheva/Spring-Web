package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.exceptions.ProductNotFoundException;
import bg.softuni.bikes_shop.model.dto.ProductDTO;
import bg.softuni.bikes_shop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {
    private final ProductService productService;

    public CategoryController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{category}")
    private String category(@PathVariable("category") String category,Model model){
        model.addAttribute("products",productService.getProductsFromCategory(category));
        model.addAttribute("categories",productService.getDistinctCategories());
        return "category";
    }




}




