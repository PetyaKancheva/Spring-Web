package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;


@Entity
public class User extends BaseEntity{
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyer")
    private List<OrderEntity> orders;


}
