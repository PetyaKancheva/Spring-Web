package bg.softuni.bikes_shop.model.entity;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.apache.catalina.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Entity
@Table(name= "orders")
public class OrderEntity extends BaseEntity{

    @ManyToOne
    @JoinColumn(name="buyer_id",nullable = false)
    private UserEntity buyer;
    @OneToMany(mappedBy = "order")
    private Set<ItemsEntity> items;
    @Column(name="total")
    private Long totalSum;
    @Column(name="date_created", nullable = false)
    private LocalDate dateCreated;
    @Column(name="status")
    private String status;

    public UserEntity getBuyer() {
        return buyer;
    }

    public OrderEntity setBuyer(UserEntity buyer) {
        this.buyer = buyer;
        return this;
    }

    public Set<ItemsEntity> getItems() {
        return items;
    }

    public OrderEntity setItems(Set<ItemsEntity> items) {
        this.items = items;
        return this;
    }

    public Long getTotalSum() {
        return totalSum;
    }

    public OrderEntity setTotalSum(Long totalSum) {
        this.totalSum = totalSum;
        return this;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public OrderEntity setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public OrderEntity setStatus(String status) {
        this.status = status;
        return this;
    }
}
