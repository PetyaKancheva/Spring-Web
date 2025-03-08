package com.example.demo.service.impl;

import com.example.demo.model.ExchangeRatesDTO;
import com.example.demo.service.CurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Override
    public String print(ExchangeRatesDTO exchangeRatesDTO) {

        return exchangeRatesDTO.toString();
    }

//    base=EUR, rates={BGN=1.9558, PLN=4.1788, USD=1.0857}

}
