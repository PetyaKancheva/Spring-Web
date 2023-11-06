package org.softuni.mobilele.model.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import org.softuni.mobilele.model.enums.EngineEnum;
import org.softuni.mobilele.model.enums.TransmissionEnum;
import org.softuni.mobilele.model.validation.YearNotInTheFuture;

public record CreateOfferDTO(
        @Positive
        @NotNull
        Long modelId,
        @Positive
        @NotNull
        Integer price,

        @Enumerated(EnumType.STRING)
        EngineEnum engine,
        @Enumerated(EnumType.STRING)

        TransmissionEnum transmission,

        @NotNull(message = "Year must be provided.")
        @Min(1945)
        @YearNotInTheFuture
        Integer year,
        @Positive
        Integer mileage,
        @NotEmpty
        @Size(min = 5, max = 512)
        String description,
        @NotEmpty
        String imageURL) {
    public static CreateOfferDTO empty() {
        return new CreateOfferDTO(null, null, null, null, null, null, null, null);
    }
}
