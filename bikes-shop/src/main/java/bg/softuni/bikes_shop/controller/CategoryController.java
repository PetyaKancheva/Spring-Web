package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.exceptions.CustomObjectNotFoundException;
import bg.softuni.bikes_shop.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoryController {
    private final ProductService productService;

    public CategoryController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{category}")
    private String category(@PathVariable("category") String category, Model model, @PageableDefault(size = 3, sort = "id") Pageable pageable) {
        List<String> categories = productService.getDistinctCategories();

        if (!categories.contains(category)) {
            throw new CustomObjectNotFoundException("Category with id: " + category + "not found!");
        }
        model.addAttribute("products", productService.getProductsFromCategoryPageable(pageable, category));
        model.addAttribute("categories", categories);
        model.addAttribute("currentCategory", category);
        return "category";
    }


}




