package bg.softuni.bikes_shop.service;

import bg.softuni.bikes_shop.model.dto.*;
import bg.softuni.bikes_shop.model.events.UserUpdateProfileEvent;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void register(UserRegisterDTO userRegisterDTO);

    void notify(UserUpdateProfileEvent event);

    List<ShortUserDTO> getAllByEmailFirsOrLastName(String searchWord);

    Optional<UserAdminUpdateDTO> getUserAdminDTO(String email);
    Optional<UserMainUpdateDTO>  getUserMainUpdateDTO(String email);

    void updateByUser(UserMainUpdateDTO userMainUpdateDTO, UserSelfUpdateDTO userSelfUpdateDTO, String  email);
    void updateByAdmin( UserMainUpdateDTO userMainUpdateDTO,UserAdminUpdateDTO userAdminUpdateDTO,String email);

    boolean isUniqueEmail(String email);
    boolean isPasswordCorrect(String email,String password);


}
