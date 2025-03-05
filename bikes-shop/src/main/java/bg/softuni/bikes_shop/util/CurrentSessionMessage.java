package bg.softuni.bikes_shop.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
@Component("currentSessionMessage")
@SessionScope
public class CurrentSessionMessage {
    private boolean isProductCreated;
    private boolean isSuccessfullyRegistered;
    private boolean isSuccessfullyUpdatedUser;
    private boolean isProductBought;

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

    public boolean isSuccessfullyUpdatedUser() {
        return isSuccessfullyUpdatedUser;
    }

    public void setSuccessfullyUpdatedUser(boolean successfullyUpdatedUser) {
        isSuccessfullyUpdatedUser = successfullyUpdatedUser;
    }

    public boolean isProductBought() {
        return isProductBought;
    }

    public void setProductBought(boolean productBought) {
        isProductBought = productBought;
    }
}

