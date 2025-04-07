package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.model.dto.CurrencyExchangeDTO;
import bg.softuni.bikes_shop.model.dto.MapRatesDTO;
import bg.softuni.bikes_shop.model.entity.CurrencyEntity;
import bg.softuni.bikes_shop.repository.CurrencyRepository;
import bg.softuni.bikes_shop.service.CurrencyService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;


    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;

    }

    @Override
    public void add(MapRatesDTO mapRatesDTO) {

        CurrencyEntity ceBGN = new CurrencyEntity();
        ceBGN.setName("BGN");
        ceBGN.setRate(mapRatesDTO.rates().get("BGN"));
        currencyRepository.save(ceBGN);

        CurrencyEntity ceUSD = new CurrencyEntity();
        ceUSD.setName("USD");
        ceUSD.setRate(mapRatesDTO.rates().get("USD"));
        currencyRepository.save(ceUSD);

        CurrencyEntity cePLN = new CurrencyEntity();
        cePLN.setName("PLN");
        cePLN.setRate(mapRatesDTO.rates().get("PLN"));
        currencyRepository.save(cePLN);
    }

    @Override
    public CurrencyExchangeDTO convert(CurrencyExchangeDTO ceDTO) {

        if (ceDTO.getCurrency().equals("USD")) {
            return mapToDTO(currencyRepository.findByName("USD"));
        } else if (ceDTO.getCurrency().equals("PLN")) {
            return mapToDTO(currencyRepository.findByName("PLN"));
        } else if (ceDTO.getCurrency().equals("BGN")) {
            return mapToDTO(currencyRepository.findByName("BGN"));
        } else if (ceDTO.getCurrency().equals("EUR")) {
            CurrencyExchangeDTO newCEDTO = new CurrencyExchangeDTO();
            newCEDTO.setRate(1.0);
            newCEDTO.setCurrency("EUR");
            return newCEDTO;
        }


        return ceDTO;
    }

    @Override
    public Double getCurrencyRate(String cookie) {
        if (cookie == null || cookie.equals("EUR")) {
            return 1d;
        } else if (cookie.equals("BGN") || cookie.equals("USD") || cookie.equals("PLN")) {
            return currencyRepository.findByName(cookie).getRate().doubleValue();
        } else {
            return 1d;
        }

    }
    @Override
    public String getCurrencyName(String cookie) {
        if (cookie == null || cookie.equals("EUR")) {
            return "EUR";
        } else if (cookie.equals("BGN") || cookie.equals("USD") || cookie.equals("PLN")) {
            return cookie;
        } else {
            return "EUR";
        }

    }


    private static CurrencyExchangeDTO mapToDTO(CurrencyEntity currencyEntity) {
        CurrencyExchangeDTO ceDTO = new CurrencyExchangeDTO();
        ceDTO.setCurrency(currencyEntity.getName());
        ceDTO.setRate(currencyEntity.getRate().doubleValue());
        return ceDTO;
    }

}
