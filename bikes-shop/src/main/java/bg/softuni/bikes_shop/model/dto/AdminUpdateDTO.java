package bg.softuni.bikes_shop.model.dto;

import bg.softuni.bikes_shop.model.UserRoleEnum;
import jakarta.validation.constraints.*;

import java.util.List;

public record AdminUpdateDTO(

        List<String> roles,


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