package bg.softuni.bikes_shop.model.dto;

public record ProductDTO(
       Long id,
        String name,
        String description,
        String category,
        Double price,
        String pictureURL
) {

}
