package bg.softuni.bikes_shop.model.dto;

import java.math.BigDecimal;
import java.util.Map;

public record MapRatesDTO(String base, Map<String, BigDecimal> rates) {
}
