package bg.softuni.bikeshop.repository;

import bg.softuni.bikeshop.model.entity.UserEntity;
import bg.softuni.bikeshop.model.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {
}
