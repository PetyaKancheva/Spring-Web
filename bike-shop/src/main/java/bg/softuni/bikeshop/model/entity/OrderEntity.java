package bg.softuni.bikeshop.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="orders")
public class OrderEntity extends BaseEntity {
    private LocalDateTime created;
    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private UserEntity buyer;

//    `list of products
//    ubyer
   private Boolean isSent;
  private Boolean   isCancelled;

}
