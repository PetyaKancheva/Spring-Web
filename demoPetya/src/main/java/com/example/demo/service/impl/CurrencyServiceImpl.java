package com.example.demo.service.impl;

import com.example.demo.model.ExchangeRatesDTO;
import com.example.demo.model.MoneyDTO;
import com.example.demo.service.CurrencyService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyServiceImpl implements CurrencyService {


    @Override
    public MoneyDTO calculateExchange(MoneyDTO moneyDTO) {
        if(moneyDTO.getCurrency().equals("BGN")){
            moneyDTO.setAmount(moneyDTO.getAmount().multiply(BigDecimal.valueOf(1.9558)));
            return moneyDTO ;
        }
        return null;
    }

//    base=EUR, rates={BGN=1.9558, PLN=4.1788, USD=1.0857}

}
