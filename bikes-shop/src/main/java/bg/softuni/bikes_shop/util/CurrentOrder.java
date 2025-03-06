package bg.softuni.bikes_shop.util;

import bg.softuni.bikes_shop.model.dto.ItemDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component("currentOrder")
@SessionScope
public class CurrentOrder {

    Set<ItemDTO> items;
    Double totalPrice;


    public CurrentOrder() {
    }

    public Set<ItemDTO> getItems() {
        return items;
    }

    public void setItems(Set<ItemDTO> items) {
        this.items = items;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void add(ItemDTO itemDTO) {
        if(this.items==null){
           this.items=new HashSet<>();
           this.items.add(itemDTO);

        }else{
            // seearch for name existing
         for(ItemDTO i:items){
                 if(i.productID()==itemDTO.productID()){
                     //TODO fix
                     int qty=i.quantity();
                     = itemDTO.quantity();
                     return;
                 }
            }
            items.add(itemDTO);
        }

    }
    public void delete(Long productID){

    }
}
