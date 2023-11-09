package bg.softuni.bikeshop.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "line_items")
public class LineItem extends BaseEntity {
    @NotNull
    private Integer quantity;
    @OneToOne
    @JoinColumn(name="id")
    private Product product;

    public Integer getQuantity() {
        return quantity;
    }

    @ManyToOne
    @JoinColumn(name = "line_item_id",nullable = false)
    private OrderEntity order;

    public OrderEntity getOrder() {
        return order;
    }

    public LineItem setOrder(OrderEntity order) {
        this.order = order;
        return this;
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
