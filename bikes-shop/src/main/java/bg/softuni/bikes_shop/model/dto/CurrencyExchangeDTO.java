package bg.softuni.bikes_shop.model.dto;

public class
CurrencyExchangeDTO  {
     private   String currency;
     private   Double rate;

    public CurrencyExchangeDTO() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
