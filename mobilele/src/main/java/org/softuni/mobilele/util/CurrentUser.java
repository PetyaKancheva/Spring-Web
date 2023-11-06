package org.softuni.mobilele.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("currentUser")
@SessionScope
public class CurrentUser {

    private String firstName;
    private String lastName;
    private boolean isLogged;
    private boolean isAdmin;
    private String email;




    public CurrentUser(){

    }

    public CurrentUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public CurrentUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CurrentUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public CurrentUser setAdmin(boolean admin) {
        isAdmin = admin;
        return this;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public CurrentUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }
    public String getFullName(){
        return getFirstName() +" " + getLastName();
    }

    public void logout() {
        setLogged(false);
        setFirstName(null);
        setLastName(null);
        setAdmin(false);
    }
}
