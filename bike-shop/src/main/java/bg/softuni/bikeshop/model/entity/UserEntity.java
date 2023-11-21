package bg.softuni.bikeshop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")

public class UserEntity extends BaseEntity {
    @Email
    @Column(unique = true,nullable = false)
    //todo custom check?
    private String email;
    @NotEmpty
    private String password;
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String LastName;

    @Column
    private String address;
    @NotNull
    private LocalDate created;

    public LocalDate getCreated() {
        return created;
    }

    public UserEntity setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public LocalDate getModified() {
        return modified;
    }

    public UserEntity setModified(LocalDate modified) {
        this.modified = modified;
        return this;
    }

    private LocalDate modified;
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    private List<UserRoleEntity> roles =new ArrayList<>();
    @OneToMany(mappedBy = "buyer")
    private List<OrderEntity>orders = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEntity() {
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return LastName;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public UserEntity setOrders(List<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }

    public UserEntity setLastName(String lastName) {
        LastName = lastName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserEntity setAddress(String address) {
        this.address = address;
        return this;
    }




    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
    }
}
