package bg.softuni.bikes_shop.util;

import bg.softuni.bikes_shop.configuration.ExchangeRateConfig;
import bg.softuni.bikes_shop.model.dto.MapRatesDTO;
import bg.softuni.bikes_shop.service.CurrencyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class CLRunner implements CommandLineRunner {

    private final RestTemplate restTemplate;
    private final ExchangeRateConfig exchangeRateConfig;
    private final CurrencyService currencyService;



    public CLRunner(RestTemplate restTemplate, ExchangeRateConfig exchangeRateConfig, CurrencyService currencyService ) {
        this.restTemplate = restTemplate;
        this.exchangeRateConfig = exchangeRateConfig;
        this.currencyService = currencyService;
    }


    @Override
    public void run(String... args) throws Exception {
        if (exchangeRateConfig.isEnabled()){

        System.out.println("*** Updating exchange rate ***");
        String url = String.valueOf(new StringBuilder()
                .append(exchangeRateConfig.getSchema())
                .append("://")
                .append(exchangeRateConfig.getHost())
                .append(exchangeRateConfig.getPath())
                .append("?base=EUR&symbols=")
                .append(String.join(",", exchangeRateConfig.getSymbols())));

     MapRatesDTO mapRatesDTO= restTemplate.getForObject( url, MapRatesDTO.class);
        currencyService.add(mapRatesDTO);
        }


    }


}


