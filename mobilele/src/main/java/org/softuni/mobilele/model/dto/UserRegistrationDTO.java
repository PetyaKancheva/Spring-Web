package org.softuni.mobilele.model.dto;

public record UserRegistrationDTO(String email,String firstName, String lastName, String password,  String confirmPassword) {
}
