package bg.softuni.bikes_shop.model.entity;

import bg.softuni.bikes_shop.model.UserRoleEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRoleEntity extends BaseEntity {
        @Enumerated(EnumType.STRING)
        private UserRoleEnum name;
}
