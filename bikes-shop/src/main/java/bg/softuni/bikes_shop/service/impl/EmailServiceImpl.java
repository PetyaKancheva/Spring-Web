package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.configuration.MailConfigProperties;
import bg.softuni.bikes_shop.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Service
public class EmailServiceImpl implements EmailService {
    private final static String REGISTRATION_EMAIL_SUBJECT_LINE ="Thank you for registering at Bikes-Shop! Please confirm your e-Mail.";
    private final JavaMailSender javaMailSender;
    private final MailConfigProperties mailConfigProperties;
    private final TemplateEngine templateEngine;

    public EmailServiceImpl(JavaMailSender javaMailSender, MailConfigProperties mailConfigProperties, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.mailConfigProperties = mailConfigProperties;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendRegistrationEmail(String userEmail, String userFirstName, String activationCode) {
        MimeMessage mimeMessage= javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        try{
            mimeMessageHelper.setTo(userEmail);
            mimeMessageHelper.setFrom(mailConfigProperties.getEmail());
            mimeMessageHelper.setReplyTo(mailConfigProperties.getEmail());
            mimeMessageHelper.setSubject(REGISTRATION_EMAIL_SUBJECT_LINE);
            mimeMessageHelper.setText(generateEmailBody(userFirstName,activationCode),true);

            javaMailSender.send(mimeMessageHelper.getMimeMessage());

        }catch (MessagingException e){
            throw new RuntimeException(e);

        }

    }

    @Override
    public void sendNotificationProfileUpdateEmail(String userEmail, String userFirstName) {

    //TODO
    }

    private String generateEmailBody(String userFirstName,String activationCode){
        Context context = new Context();
        context.setVariable("user_first_mane",userFirstName);
        context.setVariable("activation_code",activationCode);

        return templateEngine.process("/email/authentication-email.html",context);
        }

    }

