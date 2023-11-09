package bg.softuni.bikeshop.model.entity;


import bg.softuni.bikeshop.model.RoleEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

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
