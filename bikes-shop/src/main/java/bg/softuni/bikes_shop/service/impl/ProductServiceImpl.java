package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.model.dto.ProductAddDTO;
import bg.softuni.bikes_shop.model.dto.ProductDTO;
import bg.softuni.bikes_shop.model.entity.ProductEntity;
import bg.softuni.bikes_shop.repository.ProductRepository;
import bg.softuni.bikes_shop.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.aspectj.runtime.internal.Conversions.doubleValue;

@Service
public class ProductServiceImpl implements ProductService {
      private final ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }
    @Override
    public Page<ProductDTO> getProductsPageable(Pageable pageable) {
        return productRepository.findAllProductsWithCompositeNameNotNull(pageable)
                .map(ProductServiceImpl::mapToDTO);
    }


    @Override
    public Optional<ProductDTO> getSingleProduct(String compositeName) {
        return productRepository.findByCompositeName(compositeName).map(ProductServiceImpl::mapToDTO);
    }

    @Override
    public void addProduct(ProductAddDTO productAddDTO) {
            ProductEntity newProduct=mapToEntity(productAddDTO);
            productRepository.save(newProduct);

    }

    @Override
    public List<String> getDistinctCategories() {
        return productRepository.getDistinctCategories();
    }

   @Override
    public Page<ProductDTO> getProductsFromCategoryPageable(Pageable pageable,String category) {
        return productRepository.findByCategory(pageable,category)
                .map(ProductServiceImpl::mapToDTO);
    }



    private static ProductDTO mapToDTO(ProductEntity p){

             return new ProductDTO(p.getCompositeName(),p.getName(), p.getDescription(),p.getCategory(),
                     doubleValue(p.getPrice()), p.getPictureURL());
    }
    private static ProductEntity mapToEntity(ProductAddDTO productAddDTO) {
        return new ProductEntity()
                .setName(productAddDTO.name())
                .setDescription(productAddDTO.description())
                .setPrice(BigDecimal.valueOf(productAddDTO.price()))
                .setCategory(productAddDTO.category())
                .setPictureURL(productAddDTO.pictureURL());
        // composit name will be cacluated after
    }


}
