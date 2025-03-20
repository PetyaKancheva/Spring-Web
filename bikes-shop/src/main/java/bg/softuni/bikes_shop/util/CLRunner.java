package bg.softuni.bikes_shop.util;

import bg.softuni.bikes_shop.configuration.ExchangeRateConfigProperties;
import bg.softuni.bikes_shop.model.dto.MapRatesDTO;
import bg.softuni.bikes_shop.service.CurrencyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class CLRunner implements CommandLineRunner {

    private final RestTemplate restTemplate;
    private final ExchangeRateConfigProperties exchangeRateConfigProperties;
    private final CurrencyService currencyService;



    public CLRunner(RestTemplate restTemplate, ExchangeRateConfigProperties exchangeRateConfigProperties, CurrencyService currencyService ) {
        this.restTemplate = restTemplate;
        this.exchangeRateConfigProperties = exchangeRateConfigProperties;
        this.currencyService = currencyService;
    }


    @Override
    public void run(String... args) throws Exception {
        if (exchangeRateConfigProperties.isEnabled()){

        System.out.println("*** Updating exchange rate ***");
        String url = String.valueOf(new StringBuilder()
                .append(exchangeRateConfigProperties.getSchema())
                .append("://")
                .append(exchangeRateConfigProperties.getHost())
                .append(exchangeRateConfigProperties.getPath())
                .append("?base=EUR&symbols=")
                .append(String.join(",", exchangeRateConfigProperties.getSymbols())));

     MapRatesDTO mapRatesDTO= restTemplate.getForObject( url, MapRatesDTO.class);
        currencyService.add(mapRatesDTO);
        }


    }


}


