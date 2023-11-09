package bg.softuni.bikeshop.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="brands")
public class Brand extends BaseEntity{
    @NotEmpty
    private String name;
    @OneToMany(mappedBy = "brand")
    private List<Product> products =new ArrayList<>();

    public String getName() {
        return name;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Brand setProducts(List<Product> products) {
        this.products = products;
        return this;
    }
}
