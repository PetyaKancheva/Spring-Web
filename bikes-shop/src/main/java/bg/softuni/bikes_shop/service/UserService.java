package bg.softuni.bikes_shop.service;

import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.model.dto.UserUpdateDTO;
import bg.softuni.bikes_shop.model.events.UserUpdateProfileEvent;

public interface UserService {
    void register(UserRegisterDTO userRegisterDTO);
    void update (UserUpdateDTO userUpdateDTO, String  email);
    void notify(UserUpdateProfileEvent event);
}
