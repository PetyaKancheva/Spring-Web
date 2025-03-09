package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.model.entity.CurrencyEntity;
import bg.softuni.bikes_shop.repository.CurrencyRepository;
import bg.softuni.bikes_shop.service.CurrencyService;
import bg.softuni.bikes_shop.service.ItemService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;

@Service
public class CurrencyServiceImpl implements CurrencyService {
private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl( CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;

    }

    @Override
    public void add(String string) {
        // loop for symbol search BGN PLZ USD
//       CurrencyEntity BGN= new CurrencyEntity();
//        currencyRepository.save(BGN);
    }
}
