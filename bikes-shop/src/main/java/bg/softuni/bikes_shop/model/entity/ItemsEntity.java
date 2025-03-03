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

    public ItemsEntity setProduct(ProductEntity product) {
        this.product = product;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ItemsEntity setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public ItemsEntity setOrder(OrderEntity order) {
        this.order = order;
        return this;
    }
}
