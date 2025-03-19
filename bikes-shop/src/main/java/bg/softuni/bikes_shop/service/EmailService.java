package bg.softuni.bikes_shop.service;

public interface EmailService {
    void sendRegistrationEmail(String userEmail, String userFirstName, String activationCode);
    void sendNotificationProfileUpdateEmail(String userEmail, String userFirstName );
}
