package bg.softuni.bikes_shop.model.dto;

import jakarta.persistence.Column;

public record ProductDTO(
        Long id, // TODO to check to encrypt
        String name,
        String description,
        Double price,
        String pictureURL
) {

}
