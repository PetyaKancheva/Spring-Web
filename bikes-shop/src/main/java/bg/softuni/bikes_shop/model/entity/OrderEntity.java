package bg.softuni.bikes_shop.model.entity;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Map;

@Entity
@Table(name= "orders")
public class OrderEntity extends BaseEntity{
    //TODO check if Item is necessary
    @Column(name="items")
    private Map<Long , Integer > items;
    @Column(name="total")
   private Long totalSum;

    public Map<Long, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Long, Integer> items) {
        this.items = items;
    }

    public Long getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Long totalSum) {
        this.totalSum = totalSum;
    }
}
