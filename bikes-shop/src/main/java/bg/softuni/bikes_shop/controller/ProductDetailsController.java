package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.exceptions.ProductNotFoundException;
import bg.softuni.bikes_shop.model.dto.ItemDTO;
import bg.softuni.bikes_shop.model.dto.ProductDTO;
import bg.softuni.bikes_shop.service.OrderService;
import bg.softuni.bikes_shop.service.ProductService;
import bg.softuni.bikes_shop.util.CurrentOrder;
import bg.softuni.bikes_shop.util.CurrentSessionMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductDetailsController {
    private final ProductService productService;
    private final OrderService orderService;
    private final CurrentSessionMessage currentSessionMessage;

    private final CurrentOrder currentOrder;

    public ProductDetailsController(ProductService productService, OrderService orderService, CurrentSessionMessage currentSessionMessage, CurrentOrder currentOrder) {
        this.productService = productService;
        this.orderService = orderService;
        this.currentSessionMessage = currentSessionMessage;
        this.currentOrder = currentOrder;
    }

    @GetMapping("/product/{id}")
    public String details(@PathVariable("id") String id, Model model) {
        currentSessionMessage.setProductBought(false);

        ProductDTO singleProductDTO = productService.
                getSingleProduct(Long.parseLong(id))
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found!"));

        model.addAttribute("singleProduct", singleProductDTO);

        return "product-details";
    }
    @PostMapping("/product/{id}")
    public String buy(@PathVariable("id") String id,String productName,String productPrice, Integer quantity) {

        ItemDTO newItemDTO=new ItemDTO();
        newItemDTO.setProductID(Long.valueOf(id));
        newItemDTO.setProductName(productName);
        newItemDTO.setPrice(Double.parseDouble(productPrice));

        //TODO check if quantity >0
        newItemDTO.setQuantity(quantity);
        currentOrder.add(newItemDTO);
        currentSessionMessage.setProductBought(true);

        return "shopping-cart";
    }




}

