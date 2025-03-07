package bg.softuni.bikes_shop.service;

import bg.softuni.bikes_shop.model.dto.ItemDTO;
import bg.softuni.bikes_shop.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {
   void buy(String email, List<ItemDTO> itemsDTO,Double totalPrice);

    List<OrderDTO> getAllByUser(String email);
}
