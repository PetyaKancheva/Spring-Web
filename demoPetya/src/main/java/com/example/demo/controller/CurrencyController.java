package com.example.demo.controller;

import com.example.demo.service.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/currency")
    public String currency(Model model){

//       EUR-> PLN tloty
//            EXRage = 1 euro == 4.1788

        return "currency";
    }

}
