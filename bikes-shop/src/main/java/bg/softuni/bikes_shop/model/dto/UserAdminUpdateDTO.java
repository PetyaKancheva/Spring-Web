package bg.softuni.bikes_shop.model.dto;

import bg.softuni.bikes_shop.model.validation.annotation.PasswordMatch;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record UserAdminUpdateDTO(
        @NotEmpty
        List<String> roles,
        @PasswordMatch
        String newPassword
) {

    public static UserAdminUpdateDTO empty() {
        return
                new UserAdminUpdateDTO(null, null);
    }
}
