package bg.softuni.bikes_shop.util;

import bg.softuni.bikes_shop.model.events.UserRegistrationEvent;
import bg.softuni.bikes_shop.model.events.UserViewProfileEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    @EventListener (UserViewProfileEvent.class)
            public void listener(UserViewProfileEvent userViewProfileEvent){
        System.out.println("User with name: "+userViewProfileEvent.getUserName()+" viewed their profile");
    }

}
