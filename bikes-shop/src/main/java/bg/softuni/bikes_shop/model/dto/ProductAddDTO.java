package bg.softuni.bikes_shop.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductAddDTO(
        @NotEmpty(message ="Cannot be empty.")
        String name,
        @NotEmpty(message ="Cannot be empty.")
        @Size(min = 3, message= "Must be at least 3 characters.")
        String description,
        @Positive (message ="Must be a positive number.")
        Double price,
        @NotEmpty(message ="Cannot be empty.")
        String  category,
        @NotEmpty(message ="Cannot be empty.")
        String pictureURL
) {
    public static  ProductAddDTO empty(){
        return new ProductAddDTO(null,null,null,null,null);
    }

}
