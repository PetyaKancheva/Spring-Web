package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.model.entity.UserEntity;
import bg.softuni.bikes_shop.repository.UserRepository;
import bg.softuni.bikes_shop.service.UserRoleService;
import bg.softuni.bikes_shop.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {

        userRepository.save(map(userRegisterDTO));

//        currentUser.setLogged(true)
//                .setFirstName(userRegistrationDTO.firstName())
//                .setLastName(userRegistrationDTO.lastName())
//                .setEmail(userRegistrationDTO.email());

    }

    private UserEntity map(UserRegisterDTO userRegisterDTO ) {
        UserEntity newUser = new UserEntity();
        newUser.setLogged(true);
        newUser.setFirstName(userRegisterDTO.firstName());
        newUser.setLastName(userRegisterDTO.lastName());
        newUser.setEmail(userRegisterDTO.email());
        newUser .setRoles(Set.of(userRoleService.getUserRoleByName("USER")));
        newUser  .setPassword(passwordEncoder.encode(userRegisterDTO.password()));

        return  newUser;

//        return new UserEntity()
//                .setLogged(true)
//                .setFirstName(userRegisterDTO.firstName())
//                .setLastName(userRegisterDTO.lastName())
//                .setEmail(userRegisterDTO.email())
//                .setRoles(Set.of(userRoleService.getUserRoleByName("USER")))
//                .setPassword(passwordEncoder.encode(userRegisterDTO.password()));
//
    }

            }



