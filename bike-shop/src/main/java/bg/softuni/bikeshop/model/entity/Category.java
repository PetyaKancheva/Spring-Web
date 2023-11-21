package bg.softuni.bikeshop.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="categories")

public class Category extends BaseEntity{
    private String name;
    @ManyToMany(mappedBy ="categories")
    private List<Product>products = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Category() {
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }
}
