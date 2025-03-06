package bg.softuni.bikes_shop.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("currentOrder")
@SessionScope
public class CurrentOrder {
    // TODO check if could be made better
    // TODO check if list of items is possible
    Long productId;
    String productName;
    Integer quantity;

    public CurrentOrder() {
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
