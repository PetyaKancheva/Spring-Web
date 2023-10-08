package org.softuni.mobilele.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import org.softuni.mobilele.model.enums.RoleType;

@Entity
@Table(name="roles")
public class UserRoleEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private RoleType name;
}
