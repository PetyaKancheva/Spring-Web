package bg.softuni.bikes_shop.service;

import bg.softuni.bikes_shop.model.dto.ProductAddDTO;
import bg.softuni.bikes_shop.model.dto.ProductDTO;
import bg.softuni.bikes_shop.model.entity.ProductEntity;
import bg.softuni.bikes_shop.model.events.ProductAdditionEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductService {
    Page<ProductDTO> getProductsPageable(Pageable pageable);

    Optional<ProductDTO> getSingleProduct(String compositeName);
    void addProduct(ProductAddDTO productAddDTO);
    List<String> getDistinctCategories();
    Page<ProductDTO> getProductsFromCategoryPageable(Pageable pageable, String category);
    void setCompositeName(ProductEntity productEntity);
    void addCompositeName(ProductAdditionEvent event);

    Page<ProductDTO>  searchForProducts(String productToSearch, Pageable pageable);
}
