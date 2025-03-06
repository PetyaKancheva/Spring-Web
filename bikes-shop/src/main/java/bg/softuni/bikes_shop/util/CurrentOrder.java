package bg.softuni.bikes_shop.util;

import bg.softuni.bikes_shop.model.dto.ItemDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Component("currentOrder")
@SessionScope
public class CurrentOrder {
    // TODO check if could be made better
    // TODO check if list of items is possible
    List<ItemDTO> items;
    Integer totalPrice;


    public CurrentOrder() {
    }


}
