package bg.softuni.bikes_shop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class UserEntity extends BaseEntity{

    @Size(min = 3, message= "Must be at least 3 characters.")
    @Column(name="first_name")
    private String firstName;
    @Size( min=3,message="Must be longer that 2 characters.")
    @Column(name="last_name")
    private String lastName;
    @Column(name="address")
    private String Address;
    @Column(name="password", nullable = false)
    private String password;// todo Add some regex validation
    @NotEmpty(message ="Cannot be empty.")
    @Email
    @Column(name="eMail")
    private String email;
    @OneToMany(mappedBy = "buyer")
    private Set<OrderEntity> orders;
    @Column(name="is_logged")
    private Boolean isLogged; //TODO check if it is needed
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
        return Address;
    }

    public UserEntity setAddress(String address) {
        Address = address;
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

    public UserEntity setEmail(String eMail) {
        this.email = eMail;
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

    public Set<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(Set<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }
}
