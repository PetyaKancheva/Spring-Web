package com.example.demo.model;

import java.math.BigDecimal;

public class MoneyDTO {
    String currency ;
    BigDecimal amount;

    public String getCurrency() {
        return currency;
    }

    public MoneyDTO setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public MoneyDTO setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }
}
