package com.resellerapp.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope

public class LoggedUser {
    private String name;
    private boolean isLogged;

    public String getName() {
        return name;
    }

    public LoggedUser setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public LoggedUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }
}
