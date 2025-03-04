package bg.softuni.bikes_shop.util;

import bg.softuni.bikes_shop.model.UserRoleEnum;
import bg.softuni.bikes_shop.model.entity.UserRoleEntity;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component("testUser")
public class TestUser {
    String email;
    String firstName;
    String lastName;
    String address;
    Set<UserRoleEntity> roles; // TODO check to change to ENUM
    Boolean isLogged;
    int orderCount;

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

    public Set<UserRoleEntity> getRoles() {
        return roles;
    }

    public TestUser setRoles(Set<UserRoleEntity> roles) {
        this.roles = roles;
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



    public String getFullName(){
        return getFirstName() +" " + getLastName();
    }
    }
