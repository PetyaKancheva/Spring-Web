package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String compositName;
    private String name;



    public String getCompositName() {
        return compositName;
    }

    public ProductEntity setCompositName(String name) {
        this.compositName = name.toLowerCase().replace(" ","_");
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductEntity setName(String name) {
        this.name = name;
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
