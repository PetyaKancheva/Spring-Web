package com.example.demo.web;

import com.example.demo.model.MoneyDTO;
import com.example.demo.service.CurrencyService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
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
