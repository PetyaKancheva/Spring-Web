package bg.softuni.bikes_shop.model.dto;

import bg.softuni.bikes_shop.model.UserRoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record AdminUpdateDTO(

        String role,
        String email,
        String firstName,
        String lastName,
        String address,
        String country,
        String newPassword
) {
    public static AdminUpdateDTO empty() {
        return
                new AdminUpdateDTO(null, null, null, null, null, null, null);
    }
}