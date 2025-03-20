package bg.softuni.bikes_shop.service.scheduelers;

import bg.softuni.bikes_shop.service.UserActivationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ActivationCodeCleanupScheduler {
    private final UserActivationService userActivationService;

    public ActivationCodeCleanupScheduler(UserActivationService userActivationService) {
        this.userActivationService = userActivationService;
    }

    //    @Scheduled(cron="* 5 9 * * 7") //every Sunday at 9_05
    @Scheduled(cron ="0 */1 */1 * * *")// every 1 min
    public void cleanUp(){
        System.out.println("Cleanup service *** " + Instant.now() +" ***");
        userActivationService.cleanUpObsoleteActivationLinks();
        System.out.println("Cleanup service *** " + Instant.now() +" ***");
    }
}
