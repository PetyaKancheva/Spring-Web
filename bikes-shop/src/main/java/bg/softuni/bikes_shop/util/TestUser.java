package bg.softuni.bikes_shop.util;

import bg.softuni.bikes_shop.model.UserRoleEnum;
import bg.softuni.bikes_shop.model.entity.UserRoleEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Set;

@Component("testUser")
@SessionScope
public class TestUser {
    String email;
    String firstName;
    String lastName;
    String address;
    int orderCount;
    Boolean isLogged;
    Boolean isAdmin;
    Boolean isEmployee;
    Boolean isUser;

    public TestUser() {
    }


    public String getEmail() {
        return email;
    }

    public TestUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public TestUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public TestUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public TestUser setAddress(String address) {
        this.address = address;
        return this;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public TestUser setAdmin(Boolean admin) {
        isAdmin = admin;
        return this;
    }

    public Boolean getEmployee() {
        return isEmployee;
    }

    public TestUser setEmployee(Boolean employee) {
        isEmployee = employee;
        return this;
    }
    public Boolean getUser() {
        return isUser;
    }

    public TestUser setUser(Boolean user) {
        isUser = user;
        return this;
    }

    public Boolean getLogged() {
        return isLogged;
    }

    public TestUser setLogged(Boolean logged) {
        isLogged = logged;
        return this;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public TestUser setOrderCount(int orderCount) {
        this.orderCount = orderCount;
        return this;
    }


    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
    public void logout(){
        setUser(false);
        setAdmin(false);
        setEmployee(false);
        setLogged(false);
    }
}



