package bg.softuni.bikes_shop.repository;

import bg.softuni.bikes_shop.model.entity.OrderEntity;
import bg.softuni.bikes_shop.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
