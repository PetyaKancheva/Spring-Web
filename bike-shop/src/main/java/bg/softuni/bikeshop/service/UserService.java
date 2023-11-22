package bg.softuni.bikeshop.service;

import bg.softuni.bikeshop.model.dto.LoginUserDTO;
import bg.softuni.bikeshop.model.dto.RegisterUserDTO;

public interface UserService {

    void register(RegisterUserDTO registerUserDTO);

    boolean login(LoginUserDTO loginUserDTO);
}
