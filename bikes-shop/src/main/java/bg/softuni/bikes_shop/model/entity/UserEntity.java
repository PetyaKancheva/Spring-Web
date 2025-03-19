package bg.softuni.bikes_shop.model.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class UserEntity extends BaseEntity{

    @NotNull
    @Size(min = 3, message= "Must be at least 3 characters.")
    @Column(name="first_name")
    private String firstName;
    @NotNull
    @Size( min=3,message="Must be longer that 2 characters.")
    @Column(name="last_name")
    private String lastName;

    @Column(name="address")
    private String address;
    @Column(name="country")
    private String country;
    @NotNull
    @Column(name="password", nullable = false)
    private String password;// todo Add some regex validation
    @NotNull(message ="Cannot be empty.")
    @Email
    @Column(name="eMail")
    private String email;
    @OneToMany(mappedBy = "buyer")
    private Set<OrderEntity> orders;
    @Column(name="is_logged")
    private Boolean isLogged; //for when updating profiles
    @Column(name="is_authenticated")
    private Boolean isAuthenticated; //for when registering and getting authentication email
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserRoleEntity>roles;

    public UserEntity() {
        this.roles= new HashSet<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserEntity setCountry(String country) {
        this.country = country;
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

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public UserEntity setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }

    public Boolean getLogged() {
        return isLogged;
    }

    public UserEntity setLogged(Boolean logged) {
        isLogged = logged;
        return this;
    }

    public Boolean getAuthenticated() {
        return isAuthenticated;
    }

    public UserEntity setAuthenticated(Boolean authenticated) {
        isAuthenticated = authenticated;
        return this;
    }

    public Set<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(Set<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }
}
