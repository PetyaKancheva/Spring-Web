package bg.softuni.bikes_shop.util;

import bg.softuni.bikes_shop.model.events.UserViewProfileEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MyPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public MyPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
    public void publishEvent(String userName){
        UserViewProfileEvent userViewProfileEvent= new UserViewProfileEvent(this,userName);
        applicationEventPublisher.publishEvent(userViewProfileEvent);


    }
}

