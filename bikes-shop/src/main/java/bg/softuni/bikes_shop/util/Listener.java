package bg.softuni.bikes_shop.util;

import bg.softuni.bikes_shop.model.events.UserViewProfileEvent;
import bg.softuni.bikes_shop.service.EmailService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    private final EmailService emailService;

    public Listener(EmailService emailService) {
        this.emailService = emailService;
    }

    @EventListener (UserViewProfileEvent.class)
            public void listener(UserViewProfileEvent userViewProfileEvent){
        System.out.println("User with name: "+userViewProfileEvent.getUserName()+" viewed their profile");
        emailService.sendRegistrationEmail("p@mail.com",userViewProfileEvent.getUserName(),"fakeActivation code");
//        TODO is add here sending an email
//        // as if they are updating their profile.
//        send an email with activation link-
//                - create mail service
//                - set up email server
//        - avtivation link needs an entity and repo

//
    }

}
