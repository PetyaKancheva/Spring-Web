package bg.softuni.bikes_shop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

@Entity
@Table(name="currency")
public class CurrencyEntity {
    @Id

    @Column(name="name")
    String name;

    @Column(name="rate")
    BigDecimal rate;

    public  String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }

    public  BigDecimal getRate() {
        return rate;
    }

    public void setRate(@NotEmpty BigDecimal rate) {
        this.rate = rate;
    }
}
