package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.model.dto.UserLoginDTO;
import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.model.entity.UserEntity;
import bg.softuni.bikes_shop.repository.UserRepository;
import bg.softuni.bikes_shop.service.UserRoleService;
import bg.softuni.bikes_shop.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(UserLoginDTO userLoginDTO) {
        String email = userLoginDTO.email();
        UserEntity user = userRepository.findUserByEmail(email);
        if (user != null
                && passwordEncoder.matches(userLoginDTO.password(), user.getPassword())) {
//            currentUser.login(email);
            return true;
        }

        return false;
    }

    

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
    }

    private UserEntity map(UserRegisterDTO userRegisterDTO ) {
        UserEntity newUser = new UserEntity();
        newUser.setLogged(false);
        newUser.setFirstName(userRegisterDTO.firstName());
        newUser.setLastName(userRegisterDTO.lastName());
        newUser.setEmail(userRegisterDTO.email());
        newUser.setAddress(userRegisterDTO.address());
        newUser.setRoles(new HashSet<>(Arrays.asList(userRoleService.getUserRoleByName("USER"))));
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.password()));

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



