package com.example.demo.model;

import java.math.BigDecimal;

public record MoneyDTO(String currency , BigDecimal amount) {
}
