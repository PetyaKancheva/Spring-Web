package com.example.demo.web;

import com.example.demo.config.ExchangeRateConfig;
import com.example.demo.model.ExchangeRatesDTO;
import com.example.demo.service.CurrencyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestOperations;

@Controller
public class HomeController {
        private final CurrencyService currencyService;

    public HomeController(CurrencyService currencyService) {

        this.currencyService = currencyService;
    }

    @GetMapping("/")
    public String test(Model model) {


//        currencyService.refreshRates(exchangeRatesDTO);
        model.addAttribute("greeting", "Hello");

        model.addAttribute("attribute", "currencyService.print()");

        return "index";

    }

}
