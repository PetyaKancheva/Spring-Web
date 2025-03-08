package com.example.demo.web;

import com.example.demo.config.ExchangeRateConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

     private final ExchangeRateConfig exchangeRateConfig;

    public HomeController(ExchangeRateConfig exchangeRateConfig){
        this.exchangeRateConfig = exchangeRateConfig;
    }

    @GetMapping("/")
    public String test(Model model){
        String URLTemplate= String.valueOf(new  StringBuilder()
                .append(exchangeRateConfig.getSchema())
                .append("://")
                .append(exchangeRateConfig.getHost())
                .append(exchangeRateConfig.getPath())
                .append("?base=EUR&")
                .append(exchangeRateConfig.getSymbols().j)


        );

//        https://api.frankfurter.dev/v1/latest?base=EUR&symbols=BGN,USD,PLN

        model.addAttribute( "greeting","Hello");
        model.addAttribute( "url",URLTemplate);

        return "index";

    }

}
