package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.exceptions.ProductNotFoundException;
import bg.softuni.bikes_shop.model.dto.ProductDTO;
import bg.softuni.bikes_shop.model.entity.ProductEntity;
import bg.softuni.bikes_shop.repository.ProductRepository;
import bg.softuni.bikes_shop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.aspectj.runtime.internal.Conversions.doubleValue;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Set<ProductDTO> getAllProducts() {
       return productRepository.findAll().stream()
               .map(p -> new ProductDTO(p.getId(),p.getName(),p.getDescription(),doubleValue(p.getPrice()),p.getPictureURL())).collect(Collectors.toSet());

    }

    @Override
    public Optional<ProductDTO> getSingleProduct(Long id) {
        return productRepository.findById(id).map(p->new ProductDTO(id,p.getName(),p.getDescription(),doubleValue(p.getPrice()),p.getPictureURL()));
    }



}
