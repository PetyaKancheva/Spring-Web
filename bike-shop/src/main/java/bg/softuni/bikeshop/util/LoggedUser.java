package bg.softuni.bikeshop.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("loggedUser")
@SessionScope
public class LoggedUser {
    private String email;
    private String firstName;
    private String lastName;
    private boolean isLogged;
    private boolean isAdmin;

    public LoggedUser() {
    }

    public String getEmail() {
        return email;
    }

    public LoggedUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public LoggedUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public LoggedUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public LoggedUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public LoggedUser setAdmin(boolean admin) {
        isAdmin = admin;
        return this;
    }
    public void logout(){
        setLogged(false);
        setEmail(null);
        setFirstName(null);
        setLastName(null);
        setAdmin(false);
    }
}

