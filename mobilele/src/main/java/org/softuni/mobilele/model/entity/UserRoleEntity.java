package org.softuni.mobilele.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import org.softuni.mobilele.model.enums.RoleEnum;

@Entity
@Table(name="user_roles")
public class UserRoleEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public RoleEnum getRole() {
        return role;
    }

    public UserRoleEntity setRole(RoleEnum role) {
        this.role = role;
        return this;
    }
}
