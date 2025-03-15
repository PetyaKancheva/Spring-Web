package bg.softuni.bikes_shop.service;

import bg.softuni.bikes_shop.model.dto.ProductAddDTO;
import bg.softuni.bikes_shop.model.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductService {
    Page<ProductDTO> getProductsPageable(Pageable pageable);

    List<ProductDTO> getAllProducts();

   Optional<ProductDTO> getSingleProduct(Long id);

    void addProduct(ProductAddDTO productAddDTO);

    List<String> getDistinctCategories();

    Page<ProductDTO>  getProductsFromCategoryPageable(Pageable pageable,String category);


}
