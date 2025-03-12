package com.example.demo.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
@Component("currentCurrency")
@SessionScope
public class CurrentCurrency {
    String name;

    public CurrentCurrency() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
