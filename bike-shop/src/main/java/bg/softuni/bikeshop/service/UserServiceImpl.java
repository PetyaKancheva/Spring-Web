package bg.softuni.bikeshop.service;

import bg.softuni.bikeshop.model.RoleEnum;
import bg.softuni.bikeshop.model.dto.RegisterUserDTO;
import bg.softuni.bikeshop.model.entity.UserEntity;
import bg.softuni.bikeshop.model.entity.UserRoleEntity;
import bg.softuni.bikeshop.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private static PasswordEncoder passwordEncoder;
    private static UserRepository userRepository;
    @Override
    public void register(RegisterUserDTO registerUserDTO) {
        UserEntity newUser=map(registerUserDTO);
        UserRoleEntity role=new UserRoleEntity();
        role.setRole(RoleEnum.USER);
        newUser.getRoles().add(role);


            userRepository.save(newUser);
            //TODO add User ROle

    }

    private UserEntity map(RegisterUserDTO registerUserDTO){
            return new UserEntity()
                    .setEmail(registerUserDTO.getEmail())
                    .setFirstName(registerUserDTO.getFirstName())
                    .setLastName(registerUserDTO.getLastName())
                    .setAddress(registerUserDTO.getAddress())
                    .setPassword(passwordEncoder.encode(registerUserDTO.getPassword()))
                    .setCreated(LocalDateTime.now());
    }

}
