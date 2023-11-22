package bg.softuni.bikeshop.model.dto;

import jakarta.validation.constraints.Email;

public class LoginUserDTO {
    @Email
    private String email;
    // TODO
    private String password;

    public String getPassword() {
        return password;
    }

    public LoginUserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LoginUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
