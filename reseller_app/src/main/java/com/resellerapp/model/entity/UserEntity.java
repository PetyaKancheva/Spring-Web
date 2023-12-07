package com.resellerapp.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")

public class UserEntity extends BaseEntity{

    private String username;
    private String password;
    private String email;
    @OneToMany
    private List<OfferEntity> offers =new ArrayList<>();
    @OneToMany
    private List<OfferEntity> boughtOffers = new ArrayList<>();
    public UserEntity() {

    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<OfferEntity> getOffers() {
        return offers;
    }

    public UserEntity setOffers(List<OfferEntity> offers) {
        this.offers = offers;
        return this;
    }

    public List<OfferEntity> getBoughtOffers() {
        return boughtOffers;
    }

    public UserEntity setBoughtOffers(List<OfferEntity> boughtOffers) {
        this.boughtOffers = boughtOffers;
        return this;
    }


}
