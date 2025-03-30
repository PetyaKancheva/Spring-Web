package bg.softuni.bikes_shop.model.dto;

import bg.softuni.bikes_shop.model.UserRoleEnum;
import jakarta.validation.constraints.*;

import java.util.List;

public record AdminUpdateDTO(

        @Size(min=1)
        List<String> roles,

        @Email
        String email,
        @Size(min = 3,max=15, message = "Must be at least 3 characters.")
        String firstName,
        @NotEmpty
        String lastName,
        @NotEmpty
        String address,
        String country,
        @NotEmpty
        String newPassword
) {
    public static AdminUpdateDTO empty() {
        return
                new AdminUpdateDTO(null, null, null, null, null, null, null);
    }
}