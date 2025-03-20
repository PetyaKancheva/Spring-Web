package bg.softuni.bikes_shop.service;

import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.model.dto.UserUpdateDTO;
import bg.softuni.bikes_shop.model.events.UserViewProfileEvent;

public interface UserService {
    void register(UserRegisterDTO userRegisterDTO);
    void update (UserUpdateDTO userUpdateDTO, String  email);
    void listener(UserViewProfileEvent event);
}
