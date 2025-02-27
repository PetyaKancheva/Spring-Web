package bg.softuni.bikes_shop.repository;

import bg.softuni.bikes_shop.model.entity.OrderEntity;
import bg.softuni.bikes_shop.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    @Override
    List<ProductEntity> findAll();// TODO change to pagination

    @Override
    Optional<ProductEntity> findById(Long aLong);
}
