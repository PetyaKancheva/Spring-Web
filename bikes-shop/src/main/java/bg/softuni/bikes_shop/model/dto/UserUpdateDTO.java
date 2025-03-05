package bg.softuni.bikes_shop.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserUpdateDTO(

        @NotEmpty(message ="Cannot be empty.")
        @Email
        // TODO: @UniqueUserEmail check old email is corredczt must be different
        String email,
        @NotEmpty(message ="Cannot be null.")
        @Size(min = 3, message= "Must be at least 3 characters.")
        String firstName,
        @NotEmpty(message ="Cannot be null.")
        @Size(min = 3, message= "Must be at least 3 characters.")
        String lastName,
        @Size(min = 4, message= "Must be at least 4 characters.")
        String address,
       // TODO: @UniqueUserEmail
        @NotEmpty(message ="Cannot be null.")
        @Size(min = 3, message= "Must be at least 3 characters.")
        String oldPassword, // TODO: @UniqueUserEmail check old email is corredczt
        @NotEmpty(message ="Cannot be empty.")
        @Size(min = 3, message= "Must be at least 3 characters.")
        String newPassword
)            {
    public static UserUpdateDTO empty() {
        return new UserUpdateDTO(null, null, null, null,null,null);
    }
    }
