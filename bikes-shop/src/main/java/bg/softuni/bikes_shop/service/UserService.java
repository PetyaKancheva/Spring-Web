package bg.softuni.bikes_shop.service;

import bg.softuni.bikes_shop.model.dto.AdminUpdateDTO;
import bg.softuni.bikes_shop.model.dto.ShortUserDTO;
import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.model.dto.UserUpdateDTO;
import bg.softuni.bikes_shop.model.events.UserUpdateProfileEvent;
import jakarta.validation.Valid;
import org.aspectj.apache.bcel.classfile.Module;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void register(UserRegisterDTO userRegisterDTO);
    void update (UserUpdateDTO userUpdateDTO, String  email);
    void notify(UserUpdateProfileEvent event);

    List<ShortUserDTO> getAllByEmailFirsOrLastName(String searchWord);

    Optional<AdminUpdateDTO>  getAdminDTO(String email);

    void updateByAdmin( AdminUpdateDTO adminUpdateDTO,String email);
}
