package com.example.demo.controller;

import com.example.demo.model.ExchangeRatesDTO;
import com.example.demo.service.CurrencyService;
import com.example.demo.service.impl.ProductService;
import com.example.demo.util.CurrentCurrency;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private final CurrencyService currencyService;
    private final CurrentCurrency currentCurrency;
    private final ProductService productService;

    public HomeController(CurrencyService currencyService, CurrentCurrency currentCurrency, ProductService productService) {

        this.currencyService = currencyService;
        this.currentCurrency = currentCurrency;
        this.productService = productService;
    }

    @GetMapping("/")
    public String test(Model model) {
//
//            double listedPrice=1200.5;
//        MoneyDTO oldPrice=new MoneyDTO().setCurrency("EUR").setAmount(BigDecimal.valueOf(listedPrice));
//
//
//        MoneyDTO newPrice=new MoneyDTO().setCurrency("BGN").setAmount(BigDecimal.valueOf(listedPrice));
//        newPrice=currencyService.calculateExchange(newPrice);
//
//        model.addAttribute("oldPrice", oldPrice.getAmount().doubleValue());
//        model.addAttribute("newPrice", newPrice.getAmount().doubleValue());

        model.addAttribute("erDTO", new ExchangeRatesDTO("EUR",null));
        model.addAttribute("listCurrencies", List.of("EUR", "BGN", "PLN"));


        return "index";

    }

    @PostMapping("/")
    String test(@ModelAttribute("name") String name) {
        productService.create(name);


        return "index";
    }

}
