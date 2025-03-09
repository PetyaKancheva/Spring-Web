package bg.softuni.bikes_shop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

@Entity
@Table(name="currency")
public class CurrencyEntity {
    @Id
    @NotEmpty
    @Column(name="name")
    String name;
    @NotEmpty
    @Column(name="rate")
    BigDecimal rate;
}
