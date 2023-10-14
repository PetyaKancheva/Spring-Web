package org.softuni.mobilele.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String username;
    @Column
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany
    private Set<UserRoleEntity> role;
    @Column(name="image_url",columnDefinition="TEXT")
    private String imageUrl;
    @Column
    private LocalDateTime created;
    @Column
    private LocalDateTime modified;

//TODO change username to e-Mail

}
