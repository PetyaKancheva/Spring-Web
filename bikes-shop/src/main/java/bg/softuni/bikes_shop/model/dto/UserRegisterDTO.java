package bg.softuni.bikes_shop.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserRegisterDTO(
        @NotEmpty(message ="Cannot be empty.")
        @Email
        String email,
        @NotEmpty(message ="Cannot be null.")
        @Size(min = 2, message= "Must be at least 3 characters.")
        String firstName,
        @NotEmpty(message ="Cannot be null.")
        @Size(min = 2, message= "Must be at least 3 characters.")
        String lastName,
        @Size(min = 4, message= "Must be at least 4 characters.")
        String address,
       // @UniqueUserEmail TODO:
        @NotEmpty(message ="Cannot be null.")
        @Size(min = 3, message= "Must be at least 3 characters.")
        String password,
        @NotEmpty(message ="Cannot be empty.")
        String confirmPassword)
            {
    public static UserRegisterDTO empty() {
        return new UserRegisterDTO(null, null, null, null, null,null);
    }


    }
