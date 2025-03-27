package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.exceptions.CustomObjectNotFoundException;
import bg.softuni.bikes_shop.model.CustomUserDetails;
import bg.softuni.bikes_shop.model.dto.ItemDTO;
import bg.softuni.bikes_shop.model.dto.ProductDTO;
import bg.softuni.bikes_shop.service.OrderService;
import bg.softuni.bikes_shop.service.ProductService;
import bg.softuni.bikes_shop.util.CurrentOrder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductDetailsController {
    private final ProductService productService;
    private final static String SUCCESSFUL_PURCHASE_MSG =
            "Successfully purchased: %s. Please go to order list to see your current order.";
    private final static String ATTRIBUTE_MSG_NAME = "onSuccess";


    private final CurrentOrder currentOrder;

    public ProductDetailsController(ProductService productService, CurrentOrder currentOrder) {
        this.productService = productService;

        this.currentOrder = currentOrder;
    }

    @GetMapping("/product/{composite_name}")
    public String details(@PathVariable("composite_name") String compositeName, Model model) {

        ProductDTO singleProductDTO = productService.
                getSingleProduct(compositeName)
                .orElseThrow(() -> new CustomObjectNotFoundException("Product with name " + compositeName + " not found!"));

        model.addAttribute("singleProduct", singleProductDTO);

        return "product-details";
    }

    @PostMapping("/product/{composite_name}")
    public String buy(@PathVariable("composite_name") String compositeName, @AuthenticationPrincipal CustomUserDetails currentUser, String productName, String productPrice, Integer quantity, RedirectAttributes rAtt) {
        if(currentUser == null){
            return "redirect:/login";
        }



//        ItemDTO newItemDTO = new ItemDTO();
//        newItemDTO.setProductID(Long.valueOf(id));
//        newItemDTO.setProductName(productName);
//        newItemDTO.setPrice(Double.parseDouble(productPrice));
//
//        //TODO check if quantity >0
//        newItemDTO.setQuantity(quantity);
//        currentOrder.add(newItemDTO);
//
        rAtt.addFlashAttribute(ATTRIBUTE_MSG_NAME, String.format(SUCCESSFUL_PURCHASE_MSG, productName));

        return "redirect:/shopping-cart";
    }


}

