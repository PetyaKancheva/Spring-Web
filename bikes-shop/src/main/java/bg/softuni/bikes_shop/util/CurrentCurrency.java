package bg.softuni.bikes_shop.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
@Component("currentCurrency")
@SessionScope
public class CurrentCurrency {
        String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
