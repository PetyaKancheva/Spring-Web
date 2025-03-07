package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.model.dto.ItemDTO;
import bg.softuni.bikes_shop.model.dto.OrderDTO;
import bg.softuni.bikes_shop.model.entity.ItemsEntity;
import bg.softuni.bikes_shop.model.entity.OrderEntity;
import bg.softuni.bikes_shop.model.entity.UserEntity;
import bg.softuni.bikes_shop.repository.ItemRepository;
import bg.softuni.bikes_shop.repository.OrderRepository;
import bg.softuni.bikes_shop.repository.ProductRepository;
import bg.softuni.bikes_shop.repository.UserRepository;
import bg.softuni.bikes_shop.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.aspectj.runtime.internal.Conversions.doubleValue;

@Service
public class OrderServiceImpl implements OrderService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(UserRepository userRepository, ProductRepository productRepository, ItemRepository itemRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void buy(String email, List<ItemDTO> itemsDTO) {

        UserEntity buyer = userRepository.findUserByEmail(email);
        // TODO: of order exist get order
        OrderEntity newOrder = new OrderEntity();
        newOrder.setBuyer(buyer);
        newOrder.setStatus("open");
        newOrder.setDateCreated(LocalDate.now());

        List<ItemsEntity>itemsEntities=new ArrayList<>();
        // map Item DTO to newItem for each item
        for( ItemDTO itemDTO:itemsDTO){
            ItemsEntity newItem= new ItemsEntity();
            newItem.setProduct(productRepository.findById(itemDTO.getProductID()).orElseThrow());
            newItem.setQuantity(itemDTO.getQuantity());
            newItem.setOrder(newOrder);
            itemRepository.save(newItem);

        }
        newOrder.setItems(itemsEntities);

        orderRepository.save(newOrder);
    }

    @Override
    public List<OrderDTO> getAllByUser(String email) {
        return orderRepository.findAllByUser(email).stream().map(OrderServiceImpl::mapToDTO).toList();
    }

    private static OrderDTO mapToDTO(OrderEntity orderEntity) {

        return new OrderDTO(
                orderEntity.getBuyer().getEmail(),
                orderEntity.getItems().stream().map(
                        itemsEntity -> {
                            ItemDTO itemDTO = new ItemDTO();
                            itemDTO.setProductID(itemsEntity.getProduct().getId());
                            itemDTO.setProductName(itemsEntity.getProduct().getName());
                            itemDTO.setQuantity(itemsEntity.getQuantity());
                            itemDTO.setPrice(doubleValue(itemsEntity.getProduct().getPrice()));
                            return itemDTO;
                        }).collect(Collectors.toList()),
                doubleValue(orderEntity.getTotalSum()));
    }


}
