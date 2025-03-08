package com.example.demo.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyController {

    @GetMapping("/currency")
    public String currency(Model model){
       BigDecimal oldPrice =BigDecimal.valueOf(1200.5);
//       EUR-> PLN tloty
//            EXRage = 1 euro == 4.1788


       BigDecimal newPrice =BigDecimal.valueOf(0);// to calcl
        model.addAttribute("oldPrice", oldPrice);
        model.addAttribute("newPrice", newPrice);
        return "currency";
    }

}
