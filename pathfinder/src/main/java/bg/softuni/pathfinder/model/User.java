package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.UserLevels;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")

public class User extends  BaseEntity{
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column (name = "full_name",nullable = false)
    private String fullName;
    @Column
    private String email;
    @Column
    private Integer age;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserLevels level;

    public User(){
        this.roles= new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Set<Role> getRole() {
        return roles;
    }

    public User setRole(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public UserLevels getLevel() {
        return level;
    }

    public User setLevel(UserLevels level) {
        this.level = level;
        return this;
    }
}
