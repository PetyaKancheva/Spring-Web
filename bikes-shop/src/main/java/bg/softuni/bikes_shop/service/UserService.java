package bg.softuni.bikes_shop.service;

import bg.softuni.bikes_shop.model.dto.AdminUpdateDTO;
import bg.softuni.bikes_shop.model.dto.ShortUserDTO;
import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.model.dto.UserUpdateDTO;
import bg.softuni.bikes_shop.model.events.UserUpdateProfileEvent;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void register(UserRegisterDTO userRegisterDTO);
    void updateByUser(UserUpdateDTO userUpdateDTO, String  email);
    void updateByAdmin( AdminUpdateDTO adminUpdateDTO,String email);

    void notify(UserUpdateProfileEvent event);

    List<ShortUserDTO> getAllByEmailFirsOrLastName(String searchWord);

    Optional<AdminUpdateDTO>  getAdminDTO(String email);
    Optional<UserUpdateDTO>  getUserDTO(String email);


    boolean isUniqueEmail(String email);
    boolean isPasswordCorrect(String email,String password);


}
