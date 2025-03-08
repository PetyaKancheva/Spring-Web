package com.example.demo.util;

import com.example.demo.config.ExchangeRateConfig;
import com.example.demo.model.ExchangeRatesDTO;
import com.example.demo.service.CurrencyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Component
public class CLGreeter implements CommandLineRunner {

    private final RestTemplate restTemplate;
    private final ExchangeRateConfig exchangeRateConfig;
    private final CurrencyService currencyService;

    public CLGreeter(RestTemplate restTemplate, ExchangeRateConfig exchangeRateConfig, CurrencyService currencyService) {
        this.restTemplate = restTemplate;
        this.exchangeRateConfig = exchangeRateConfig;
        this.currencyService = currencyService;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("running");

        String URLTemplate = String.valueOf(new StringBuilder()
                .append(exchangeRateConfig.getSchema())
                .append("://")
                .append(exchangeRateConfig.getHost())
                .append(exchangeRateConfig.getPath())
                .append("?base=EUR&symbols=")
                .append(String.join(",", exchangeRateConfig.getSymbols())));



        ExchangeRatesDTO exchangeRatesDTO = restTemplate
                .getForObject(URLTemplate,ExchangeRatesDTO.class);

        System.out.println(exchangeRatesDTO.toString());
//            currencyService.print(exchangeRatesDTO);
    }
}
