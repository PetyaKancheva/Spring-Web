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
    @Column(name="date_created")
    private LocalDate dateCreated;
    @Column(name="status")
    private String status;

    public UserEntity getBuyer() {
        return buyer;
    }

    public void setBuyer(UserEntity buyer) {
        this.buyer = buyer;
    }


    public Set<ItemsEntity> getItems() {
        return items;
    }

    public void setItems(Set<ItemsEntity> items) {
        this.items = items;
    }

    public Long getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Long totalSum) {
        this.totalSum = totalSum;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
