package bg.softuni.pathfinder.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="users")

public class User extends  BaseEntity{
    @Column
    private String username;
    @Column
    private String password;
    @Column (name = "full_name")
    private String fullName;
    @Column
    private String email;
    @Column
    private Integer age;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> role;

    @Enumerated(EnumType.STRING)
    private UserLevels level;

    public User(){

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
        return role;
    }

    public User setRole(Set<Role> role) {
        this.role = role;
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
