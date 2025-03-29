package bg.softuni.bikes_shop.model.dto;

import bg.softuni.bikes_shop.model.UserRoleEnum;
import jakarta.validation.constraints.*;

public record AdminUpdateDTO(
        @NotNull
        String role,
        @NotNull
                @Email
        String email,
        @Size(min = 3, message= "Must be at least 3 characters.")
        String firstName,
        @Size(min = 3, message= "Must be at least 3 characters.")
        String lastName,
        @Size(min = 4, message= "Must be at least 4 characters.")
        String address,

        String country,
        @NotBlank(message ="Cannot be empty.")
        @Size(min = 3, message= "Must be at least 3 characters.")
        String newPassword
) {
    public static AdminUpdateDTO empty() {
        return
                new AdminUpdateDTO(null, null, null, null, null, null, null);
    }
}