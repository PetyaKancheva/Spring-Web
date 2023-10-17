package org.softuni.mobilele.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class MessageToUser {
    private boolean successfulLogin;


    public boolean isSuccessfulLogin() {
        return successfulLogin;
    }

    public MessageToUser setSuccessfulLogin(boolean successfulLogin) {
        this.successfulLogin = successfulLogin;
        return this;
    }
}
