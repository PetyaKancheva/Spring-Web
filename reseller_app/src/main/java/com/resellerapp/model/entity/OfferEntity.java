package com.resellerapp.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="offers")
public class OfferEntity extends BaseEntity {
    private String description;
    private BigDecimal price;
    @ManyToOne
    private ConditionEntity condition;


}
