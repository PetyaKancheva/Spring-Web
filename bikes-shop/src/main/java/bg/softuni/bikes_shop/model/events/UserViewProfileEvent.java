package bg.softuni.bikes_shop.model.events;

import org.springframework.context.ApplicationEvent;

public class UserViewProfileEvent extends ApplicationEvent {
        private final String userName;
    public UserViewProfileEvent(Object source, String userName) {
        super(source);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
