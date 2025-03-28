package bg.softuni.bikes_shop.service;

import bg.softuni.bikes_shop.model.dto.AdminUpdateDTO;
import bg.softuni.bikes_shop.model.dto.ShortUserDTO;
import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.model.dto.UserUpdateDTO;
import bg.softuni.bikes_shop.model.events.UserUpdateProfileEvent;

import java.util.List;

public interface UserService {
    void register(UserRegisterDTO userRegisterDTO);
    void update (UserUpdateDTO userUpdateDTO, String  email);
    void notify(UserUpdateProfileEvent event);

    List<ShortUserDTO> getByEmailFirstNameOrLastName(String searchWord);
}
