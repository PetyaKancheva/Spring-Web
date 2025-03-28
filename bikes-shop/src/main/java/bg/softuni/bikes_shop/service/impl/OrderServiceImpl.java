package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.exceptions.CustomObjectNotFoundException;
import bg.softuni.bikes_shop.model.dto.ItemDTO;
import bg.softuni.bikes_shop.model.dto.OrderDTO;
import bg.softuni.bikes_shop.model.entity.ItemEntity;
import bg.softuni.bikes_shop.model.entity.OrderEntity;
import bg.softuni.bikes_shop.repository.ItemRepository;
import bg.softuni.bikes_shop.repository.OrderRepository;
import bg.softuni.bikes_shop.repository.ProductRepository;
import bg.softuni.bikes_shop.repository.UserRepository;
import bg.softuni.bikes_shop.service.OrderService;
import bg.softuni.bikes_shop.service.ProductService;
import bg.softuni.bikes_shop.util.CurrentOrder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.aspectj.runtime.internal.Conversions.doubleValue;

@Service
public class OrderServiceImpl implements OrderService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final ProductService productService;

    public OrderServiceImpl(UserRepository userRepository, ProductRepository productRepository, ItemRepository itemRepository, OrderRepository orderRepository, ProductService productService) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    @Override
    public void buy(String email, CurrentOrder currentOrder) {

        OrderEntity newOrder = new OrderEntity()
                .setBuyer(userRepository.findUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with email: " + email + "not found!")))
                .setStatus("open")
                .setDateCreated(LocalDate.now())
                .setTotalSum(BigDecimal.valueOf(currentOrder.getTotalPrice()));

        orderRepository.save(newOrder);

    }

    @Override
    public List<OrderDTO> getAllByUser(String email) {
        return orderRepository
                .findAllByBuyerEmail(email)
                .stream().map(OrderServiceImpl::mapToDTO)
                .toList();
    }

    private static OrderDTO mapToDTO(OrderEntity orderEntity) {

        return new OrderDTO(
                orderEntity.getBuyer().getEmail(),
                orderEntity.getItems().stream().map(
                        itemsEntity -> {
                            ItemDTO itemDTO = new ItemDTO();
                            itemDTO.setProductCompositeName(itemsEntity.getProduct().getCompositeName());
                            itemDTO.setProductName(itemsEntity.getProduct().getName());
                            itemDTO.setQuantity(itemsEntity.getQuantity());
                            itemDTO.setPrice(doubleValue(itemsEntity.getProduct().getPrice()));
                            return itemDTO;
                        }).collect(Collectors.toList()),
                doubleValue(orderEntity.getTotalSum()));
    }


}
