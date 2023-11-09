package bg.softuni.bikeshop.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="products")
public class Product extends BaseEntity {

    @NotEmpty
    private String name;
    @NotNull
    private BigDecimal price;
    @ManyToOne
    private Brand brand;
    @ManyToMany(mappedBy = "products")
    private List<Category> categories = new ArrayList<>();




}
