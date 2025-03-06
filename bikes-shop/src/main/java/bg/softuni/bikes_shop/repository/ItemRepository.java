package bg.softuni.bikes_shop.repository;

import bg.softuni.bikes_shop.model.entity.ItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemsEntity,Long> {
}
