package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.dto.ProductDTO;
import bg.softuni.bikes_shop.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private String allProducts(Model model, @PageableDefault(size = 3,sort = "id") Pageable pageable  ) {
        Page<ProductDTO> products=productService.getProductsPageable(pageable);
            products.previousPageable();
        model.addAttribute("products",products);
//        model.addAttribute("products",productService.getAllProducts());
        model.addAttribute("categories", productService.getDistinctCategories());
        return "index";
    }

    @GetMapping("/about")
    private String about() {
        return "about";
    }

    @GetMapping("/services")
    private String services() {
        return "services";
    }

    @GetMapping("/contacts")
    private String contacts() {
        return "contacts";
    }
}
