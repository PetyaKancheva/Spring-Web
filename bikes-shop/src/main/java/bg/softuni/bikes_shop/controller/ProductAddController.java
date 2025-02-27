package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.dto.ProductAddDTO;
import bg.softuni.bikes_shop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product/")
public class ProductAddController {
    private final ProductService productService;

    public ProductAddController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/add")
    private String addProduct(Model model){
            // add check if employee
        // sucessfuööy created to show different message
        model.addAttribute("productAddDTO", ProductAddDTO.empty());

        return "product-add";
    }
@PostMapping ("/add")
private String addProduct(@Valid ProductAddDTO productAddDTO, BindingResult bindingResult, RedirectAttributes rAtt){
    // add check if employee
        if (bindingResult.hasErrors()){
            rAtt.addFlashAttribute("productAddDTO",productAddDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.productAddDTO", bindingResult);
            return "redirect:/product/add";
        }
        // check if product name exists



        productService.addProduct(productAddDTO);
        return "redirect:/product/add";

}
}
