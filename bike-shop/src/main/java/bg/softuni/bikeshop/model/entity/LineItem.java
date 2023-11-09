package bg.softuni.bikeshop.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="line_items")
public class LineItem extends BaseEntity {
    @NotNull
    private Integer quantity;
    @OneToOne(mappedBy = "line_items")
    private Product product;

    public Integer getQuantity() {
        return quantity;
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
