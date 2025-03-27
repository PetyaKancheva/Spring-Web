package bg.softuni.bikes_shop.model.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductAddDTO(
        @NotNull(message ="Cannot be empty.")
        @Size(min = 3, message= "Must be at least 3 characters.")
        String name,
        @NotNull(message ="Cannot be empty.")
        @Size(min = 5, message= "Must be at least 5 characters.")
        String description,
        @Positive (message ="Must be a positive number.")
        Double price,
        @NotNull(message ="Cannot be empty.")
        String  category,
        @NotNull(message ="Cannot be empty.")
        String pictureURL
) {
    public static  ProductAddDTO empty(){
        return new ProductAddDTO(null,null,null,null,null);
    }

}
