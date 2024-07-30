package bg.softuni.bikes_shop.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="items")
public class ItemsEntity extends BaseEntity{
    @OneToOne
    private ProductEntity product;
    @Column(name="quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name="order_id",nullable = false)
    private OrderEntity order;

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
