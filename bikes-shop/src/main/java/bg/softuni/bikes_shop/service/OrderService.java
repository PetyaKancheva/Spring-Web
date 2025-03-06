package bg.softuni.bikes_shop.service;

public interface OrderService {
    void buy(Long id, String email, Integer quantity);
}
