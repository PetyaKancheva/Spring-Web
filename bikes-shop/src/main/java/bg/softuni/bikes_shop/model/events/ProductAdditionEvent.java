package bg.softuni.bikes_shop.model.events;

import org.springframework.context.ApplicationEvent;

public class ProductAdditionEvent extends ApplicationEvent {
    private final String productName;


    public ProductAdditionEvent(Object source, String productName) {
        super(source);
        this.productName = productName;

    }

    public String getProductName() {
        return productName;
    }
}
