package bg.softuni.bikes_shop.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("currentOffer")
@SessionScope
public class CurrentOffer {
    // TODO check if could be made better
    // TODO check if list of items is possible
    Long productId;
    Integer quantity;

    public CurrentOffer() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
