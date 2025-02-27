package bg.softuni.bikes_shop.service;

import bg.softuni.bikes_shop.model.dto.ProductAddDTO;
import bg.softuni.bikes_shop.model.dto.ProductDTO;

import java.util.Optional;
import java.util.Set;

public interface ProductService {
    Set<ProductDTO> getAllProducts();

   Optional<ProductDTO> getSingleProduct(Long id);

    void addProduct(ProductAddDTO productAddDTO);
}
