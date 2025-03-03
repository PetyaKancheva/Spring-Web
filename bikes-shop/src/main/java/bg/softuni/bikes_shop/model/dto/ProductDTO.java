package bg.softuni.bikes_shop.model.dto;

public record ProductDTO(
        Long id, // TODO to check to encrypt
        String name,
        String description,
        String category,
        Double price,
        String pictureURL
) {

}
