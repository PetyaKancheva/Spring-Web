package bg.softuni.bikes_shop.model.dto;

public record CurrencyExchangeDTO(
        String currency,
        Double rate
) {
    public static CurrencyExchangeDTO empty() {
        return new CurrencyExchangeDTO(null, null);
    }

}
