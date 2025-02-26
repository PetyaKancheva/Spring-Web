package bg.softuni.bikes_shop.service;

import bg.softuni.bikes_shop.model.dto.ProductDTO;

import java.util.Set;

public interface ProductService {
    Set<ProductDTO> getAllProducts();
}
