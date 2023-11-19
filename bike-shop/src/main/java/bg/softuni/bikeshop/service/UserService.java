package bg.softuni.bikeshop.service;

import bg.softuni.bikeshop.model.dto.RegisterUserDTO;

public interface UserService {

    boolean register(RegisterUserDTO registerUserDTO);
}
