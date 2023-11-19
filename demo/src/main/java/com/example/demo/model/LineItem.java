package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity

public class LineItem  extends BaseEntity{
    private String name;
    @OneToOne
    private Product product;
    private Integer quantity;

}
