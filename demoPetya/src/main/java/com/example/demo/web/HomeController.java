package com.example.demo.web;

import com.example.demo.config.ExchangeRateConfig;
import com.example.demo.model.ExchangeRatesDTO;
import com.example.demo.model.MoneyDTO;
import com.example.demo.service.CurrencyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestOperations;

import java.math.BigDecimal;

@Controller
public class HomeController {
        private final CurrencyService currencyService;

    public HomeController(CurrencyService currencyService) {

        this.currencyService = currencyService;
    }

    @GetMapping("/")
    public String test(Model model) {

            double listedPrice=1200.5;
        MoneyDTO oldPrice=new MoneyDTO().setCurrency("EUR").setAmount(BigDecimal.valueOf(listedPrice));


        MoneyDTO newPrice=new MoneyDTO().setCurrency("BGN").setAmount(BigDecimal.valueOf(listedPrice));
        newPrice=currencyService.calculateExchange(newPrice);

        model.addAttribute("oldPrice", oldPrice.getAmount().doubleValue());
        model.addAttribute("newPrice", newPrice.getAmount().doubleValue());

        return "index";

    }

}
