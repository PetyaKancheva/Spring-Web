package bg.softuni.bikes_shop.model.entity;

import bg.softuni.bikes_shop.model.UserRoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name="user_role")
public class UserRoleEntity extends BaseEntity {
        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private UserRoleEnum name;

}
