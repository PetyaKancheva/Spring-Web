package bg.softuni.bikeshop.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "line_items")
public class LineItem extends BaseEntity {
    @NotNull
    private Integer quantity;
    @OneToOne
    private Product product;

    public Integer getQuantity() {
        return quantity;
    }

    public LineItem() {
    }

    public LineItem setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public LineItem setProduct(Product product) {
        this.product = product;
        return this;
    }
}
