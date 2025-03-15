package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.dto.ProductAddDTO;
import bg.softuni.bikes_shop.service.ProductService;
import bg.softuni.bikes_shop.util.CurrentSessionMessage;
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
    private final CurrentSessionMessage currentSessionMessage;

    public ProductAddController(ProductService productService, CurrentSessionMessage currentSessionMessage) {
        this.productService = productService;
        this.currentSessionMessage = currentSessionMessage;
    }

    @GetMapping("/add")
    private String addProduct(Model model) {
        model.addAttribute("productAddDTO", ProductAddDTO.empty());
        currentSessionMessage.setProductCreated(true);
        return "product-add";
    }

    @PostMapping("/add")
    private String addProduct(@Valid ProductAddDTO productAddDTO, BindingResult bindingResult, RedirectAttributes rAtt) {
        // TODO:add check if employee
        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("productAddDTO", productAddDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.productAddDTO", bindingResult);
//            isCreated=true;
            return "product-add";

        }
        // TODO:check if product name exists


        productService.addProduct(productAddDTO);
        return "redirect:/";

    }
}
