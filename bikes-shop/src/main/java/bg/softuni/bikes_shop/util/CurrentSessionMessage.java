package bg.softuni.bikes_shop.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
@Component("currentSessionMessage")
@SessionScope
public class CurrentSessionMessage {
    private boolean isProductCreated;
    private boolean isSuccessfullyRegistered;

    public CurrentSessionMessage() {
    }

    public boolean isProductCreated() {
        return isProductCreated;
    }

    public void setProductCreated(boolean productCreated) {
        isProductCreated = productCreated;
    }

    public boolean isSuccessfullyRegistered() {
        return isSuccessfullyRegistered;
    }

    public void setSuccessfullyRegistered(boolean successfullyRegistered) {
        isSuccessfullyRegistered = successfullyRegistered;
    }
}

