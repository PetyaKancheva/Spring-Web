package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.model.dto.ProductAddDTO;
import bg.softuni.bikes_shop.model.dto.ProductDTO;
import bg.softuni.bikes_shop.model.entity.ItemsEntity;
import bg.softuni.bikes_shop.model.entity.OrderEntity;
import bg.softuni.bikes_shop.model.entity.ProductEntity;
import bg.softuni.bikes_shop.model.entity.UserEntity;
import bg.softuni.bikes_shop.repository.OrderRepository;
import bg.softuni.bikes_shop.repository.ProductRepository;
import bg.softuni.bikes_shop.repository.UserRepository;
import bg.softuni.bikes_shop.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.aspectj.runtime.internal.Conversions.doubleValue;

@Service
public class ProductServiceImpl implements ProductService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }
    @Override
    public Page<ProductDTO> getProductsPageable(Pageable pageable) {
        return productRepository
                .findAll(pageable)
                .map(ProductServiceImpl::mapToDTO);
    }

    @Override
    public Set<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductServiceImpl::mapToDTO).collect(Collectors.toSet());

    }

    @Override
    public Optional<ProductDTO> getSingleProduct(Long id) {
        return productRepository.findById(id).map(ProductServiceImpl::mapToDTO);
    }

    @Override
    public void addProduct(ProductAddDTO productAddDTO) {
            ProductEntity newProduct=mapToEntity(productAddDTO);
        productRepository.save(newProduct);

    }

    @Override
    public Set<String> getDistinctCategories() {
        return productRepository.getDistinctCategories();
    }

   @Override
    public Page<ProductDTO> getProductsFromCategoryPageable(Pageable pageable,String category) {
        return productRepository.findByCategory(pageable,category)
                .map(ProductServiceImpl::mapToDTO);
    }

    @Override
    public void buy(Long id, String email) {
        // TODO check if this should be in other service
            UserEntity buyer =userRepository.findUserByEmail(email);
            //if order does not exist create new order
        // FIND order??
        // ALWAY Crete new item
        OrderEntity newOrder = new OrderEntity();
        ItemsEntity newItem = new ItemsEntity();

        newItem.setProduct(productRepository.findById(id).orElseThrow());
        newItem.setQuantity(1); // later to add quantity functionality
        newItem.setOrder(newOrder);
        // need to fetch existing items Set
        if (newOrder.getItems()==null){
            // create new
            newOrder.setItems(new HashSet<>(Arrays.asList(newItem)));
        }else{
            //Fetch existing
            newOrder.getItems().add(newItem);
        }
            newOrder.setBuyer(buyer);
            newOrder.setStatus("open");
            newOrder.setDateCreated(LocalDate.now());
            orderRepository.save(newOrder);


    }

    private static ProductDTO mapToDTO(ProductEntity p){
             return new ProductDTO(p.getId(), p.getName(), p.getDescription(),p.getCategory(), doubleValue(p.getPrice()), p.getPictureURL());
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
