package com.example.demo.controller;

import com.example.demo.model.ExchangeRatesDTO;
import com.example.demo.service.CurrencyService;
import com.example.demo.util.CurrentCurrency;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    private final CurrencyService currencyService;
    private final CurrentCurrency currentCurrency;

    public HomeController(CurrencyService currencyService, CurrentCurrency currentCurrency) {

        this.currencyService = currencyService;
        this.currentCurrency = currentCurrency;
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
    public String test(@ModelAttribute String currency) {

        System.out.println(currency +"   to" );
        System.out.println("from");

        return "redirect:/";
    }

}
