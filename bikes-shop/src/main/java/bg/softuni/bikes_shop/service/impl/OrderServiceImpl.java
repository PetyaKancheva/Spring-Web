package bg.softuni.bikes_shop.service.impl;

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
import java.util.Arrays;
import java.util.HashSet;

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
    public void buy(Long id, String email,Integer quantity) {

        UserEntity buyer =userRepository.findUserByEmail(email);
       // TODO: of order exist get order
        OrderEntity newOrder = new OrderEntity();
        ItemsEntity newItem = new ItemsEntity();

        newItem.setProduct(productRepository.findById(id).orElseThrow());
        newItem.setQuantity(1);
        newItem.setOrder(newOrder);
        itemRepository.save(newItem);

        if (newOrder.getItems()==null){
            newOrder.setItems(new HashSet<>(Arrays.asList(newItem)));
        }else{
            newOrder.getItems().add(newItem);
        }
        newOrder.setBuyer(buyer);
        newOrder.setStatus("open");
        newOrder.setDateCreated(LocalDate.now());
        orderRepository.save(newOrder);


    }
}
