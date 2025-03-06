package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.UserRoleEnum;
import bg.softuni.bikes_shop.model.dto.ProductDTO;
import bg.softuni.bikes_shop.model.entity.UserRoleEntity;
import bg.softuni.bikes_shop.service.ProductService;
import bg.softuni.bikes_shop.service.UserService;
import bg.softuni.bikes_shop.util.TestUser;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final ProductService productService;
    private final TestUser testUser;


    public HomeController(ProductService productService, TestUser testUser, UserService userService) {
        this.productService = productService;
        this.testUser = testUser;

    }

    @GetMapping("/")
    private String allProducts(Model model, @PageableDefault(size = 3,sort = "id") Pageable pageable  ) {
        model.addAttribute("products",productService.getProductsPageable(pageable));

        model.addAttribute("categories", productService.getDistinctCategories());
        model.addAttribute("testUser",testUser);

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
    @GetMapping("/logout")
    private String logout(){
       testUser.logout();
       return "redirect:/";
    }
}
