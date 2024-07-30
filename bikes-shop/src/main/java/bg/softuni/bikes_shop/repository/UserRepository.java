package bg.softuni.bikes_shop.repository;

import bg.softuni.bikes_shop.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<UserEntity,Long> {
}
