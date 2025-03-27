package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.exceptions.CustomObjectNotFoundException;
import bg.softuni.bikes_shop.model.dto.ProductAddDTO;
import bg.softuni.bikes_shop.model.dto.ProductDTO;
import bg.softuni.bikes_shop.model.entity.ProductEntity;
import bg.softuni.bikes_shop.model.events.ProductAdditionEvent;
import bg.softuni.bikes_shop.repository.ProductRepository;
import bg.softuni.bikes_shop.service.ProductService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
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
    private final ApplicationEventPublisher appEventPublisher;


    public ProductServiceImpl(ProductRepository productRepository, ApplicationEventPublisher appEventPublisher) {
        this.productRepository = productRepository;

        this.appEventPublisher = appEventPublisher;
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
        ProductEntity newProduct = mapToEntity(productAddDTO);
        productRepository.save(newProduct);
        appEventPublisher.publishEvent(new ProductAdditionEvent("ProductService",productAddDTO.name()));

    }

    @EventListener(ProductAdditionEvent.class)
    @Override
    public void addCompositeName(ProductAdditionEvent event) {
            this.setCompositeName(productRepository.findByName( event.getProductName())
                    .orElseThrow(()->new CustomObjectNotFoundException("product not found")));

        System.out.println("New Product" +event.getProductName()+ "created and composite name set");
    }

    @Override
    public List<String> getDistinctCategories() {
        return productRepository.getDistinctCategories();
    }

    @Override
    public Page<ProductDTO> getProductsFromCategoryPageable(Pageable pageable, String category) {
        return productRepository.findByCategory(pageable, category)
                .map(ProductServiceImpl::mapToDTO);
    }

    @Override
    public void setCompositeName(ProductEntity productEntity) {
        String productName = productEntity.getName();
        int iCount = 0;
        String buildCompositeName = productName.toLowerCase().replace(" ", "_");
        while (iCount >= 0) {

            if (productRepository.findByCompositeName(buildCompositeName).isPresent()) {
                iCount += 1;
                buildCompositeName = productName.toLowerCase().replace(" ", "_") + "_" + iCount;
            } else {
                productEntity.setCompositeName(buildCompositeName);
                productRepository.save(productEntity);
                return;
            }

        }
    }

    private static ProductDTO mapToDTO(ProductEntity p) {
        return new ProductDTO(p.getCompositeName(), p.getName(), p.getDescription(), p.getCategory(),
                doubleValue(p.getPrice()), p.getPictureURL());
    }

    private static ProductEntity mapToEntity(ProductAddDTO productAddDTO) {
        return new ProductEntity()
                .setName(productAddDTO.name())
                .setDescription(productAddDTO.description())
                .setPrice(BigDecimal.valueOf(productAddDTO.price()))
                .setCategory(productAddDTO.category())
                .setPictureURL(productAddDTO.pictureURL());
    }


}
