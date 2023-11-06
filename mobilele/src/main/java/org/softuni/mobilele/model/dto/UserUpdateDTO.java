package org.softuni.mobilele.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.softuni.mobilele.model.enums.RoleEnum;

import java.time.LocalDateTime;

public class UserUpdateDTO {
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "is_active")
    private Boolean isActive;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;
    @Column(name="image_url",columnDefinition="TEXT")
    private String imageUrl;
    @Column
    private LocalDateTime created;
    @Column
    private LocalDateTime modified;
}
