package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.model.dto.UserUpdateDTO;
import bg.softuni.bikes_shop.model.entity.UserEntity;
import bg.softuni.bikes_shop.repository.UserRepository;
import bg.softuni.bikes_shop.service.UserRoleService;
import bg.softuni.bikes_shop.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class    UserServiceImpl implements UserService {
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
    @Override
    public void update(UserUpdateDTO userUpdateDTO, String email) {
//        UserEntity user = userRepository.findUserByEmail(email);
//        // compare??
//        user.setFirstName(userUpdateDTO.firstName());
//        user.setLastName(userUpdateDTO.lastName());
//
//        String newEmail = userUpdateDTO.email();
//        if (userRepository.findUserByEmail(newEmail) == null) {
//            user.setEmail(newEmail);
//        } else {
////            give error email already in use
//        }
//        user.setAddress(userUpdateDTO.address());
//
////        if (!passwordEncoder.matches(userUpdateDTO.newPassword(), user.getPassword())) {
////            user.setPassword(passwordEncoder.encode(userUpdateDTO.newPassword()));
////        } else {
////           // gove error same pass
////        }
//
//            mapToTestUser(testUser,user);
//            userRepository.save(user);

    }


    private UserEntity map(UserRegisterDTO userRegisterDTO) {
        return   new UserEntity()
                    .setLogged(false)
                    .setFirstName(userRegisterDTO.firstName())
                    .setLastName(userRegisterDTO.lastName())
                    .setEmail(userRegisterDTO.email())
                    .setAddress(userRegisterDTO.address())
                    .setRoles(new HashSet<>(Arrays.asList(userRoleService.getUserRoleByName("USER"))))
                    .setPassword(passwordEncoder.encode(userRegisterDTO.password()));



    }




}



