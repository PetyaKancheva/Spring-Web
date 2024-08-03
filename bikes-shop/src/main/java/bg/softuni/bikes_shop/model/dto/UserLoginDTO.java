package bg.softuni.bikes_shop.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.apache.catalina.User;

public record UserLoginDTO (
    @NotEmpty(message ="Cannot be empty.")
    @Email
    String email,
    @NotEmpty(message ="Cannot be null.")
    @Size(min = 3, message= "Must be at least 3 characters.")
    String password) {
    public static UserLoginDTO empty(){
        return new UserLoginDTO(null,null);
    };
}
