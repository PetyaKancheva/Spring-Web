package bg.softuni.bikes_shop.service;

import bg.softuni.bikes_shop.model.dto.CurrencyExchangeDTO;
import bg.softuni.bikes_shop.model.dto.MapRatesDTO;

public interface CurrencyService {
    void add(MapRatesDTO mapRatesDTO);

    CurrencyExchangeDTO convert(CurrencyExchangeDTO currencyExchangeDTO);
}
