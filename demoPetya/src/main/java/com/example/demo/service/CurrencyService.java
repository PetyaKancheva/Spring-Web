package com.example.demo.service;

import com.example.demo.model.ExchangeRatesDTO;
import com.example.demo.model.MoneyDTO;

public interface CurrencyService {


    MoneyDTO calculateExchange(MoneyDTO oldPrice);
}
