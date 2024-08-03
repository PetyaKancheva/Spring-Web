package bg.softuni.bikes_shop.service;

import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;

public interface UserService {
    void register(UserRegisterDTO userRegisterDTO);
}
