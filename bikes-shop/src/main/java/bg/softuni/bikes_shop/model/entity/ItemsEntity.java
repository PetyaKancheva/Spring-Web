package bg.softuni.bikes_shop.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="items")
public class ItemsEntity extends BaseEntity{
    @Column(name="product")
    private ProductEntity product;
    @Column(name="quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name="order_id",nullable = false)
    private OrderEntity order;

}
