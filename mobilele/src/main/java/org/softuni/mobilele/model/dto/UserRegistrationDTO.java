package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Size;
import org.softuni.mobilele.model.validation.UniqueUserEmail;

public record UserRegistrationDTO(
        @NotEmpty(message ="Cannot be empty.")
        @Email
        String email,
        @NotEmpty(message ="Cannot be null.")
        @Size(min = 2, message= "Must be at least 2 characters.")
        String firstName,
        @NotEmpty(message ="Cannot be null.")
        @Size(min = 2, message= "Must be at least 2 characters.")
        String lastName,
        @UniqueUserEmail
        @NotEmpty(message ="Cannot be null.")
        @Size(min = 2, message= "Must be at least 2 characters.")
        String password,
        @NotEmpty(message ="Cannot be empty.")
        String confirmPassword) {


    public static UserRegistrationDTO empty() {
        return new UserRegistrationDTO(null, null, null, null, null);
    }

}

