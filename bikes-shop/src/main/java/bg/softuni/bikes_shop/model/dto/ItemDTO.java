package bg.softuni.bikes_shop.model.dto;

public record ItemDTO(
        Long productID,
        String productName,
        Double price,
        Integer quantity) {
}
