package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.model.UserRoleEnum;
import bg.softuni.bikes_shop.model.dto.UserLoginDTO;
import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.model.dto.UserUpdateDTO;
import bg.softuni.bikes_shop.model.entity.UserEntity;
import bg.softuni.bikes_shop.repository.UserRepository;
import bg.softuni.bikes_shop.service.UserRoleService;
import bg.softuni.bikes_shop.service.UserService;
import bg.softuni.bikes_shop.util.TestUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;
    private final TestUser testUser;

    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService, PasswordEncoder passwordEncoder, TestUser testUser) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
        this.testUser = testUser;
    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {
        String email = userLoginDTO.email();
        UserEntity user = userRepository.findUserByEmail(email);
        if (user != null
                && passwordEncoder.matches(userLoginDTO.password(), user.getPassword())) {
            // TODO only one USER in database!!!!
            mapToTestUser(testUser, user);
            return true;
        }
        // TODO some error msg
        return false;
    }

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {

        userRepository.save(map(userRegisterDTO));
    }
    @Override
    public void update(UserUpdateDTO userUpdateDTO, String email) {
        UserEntity user = userRepository.findUserByEmail(email);
        // compare??
        user.setFirstName(userUpdateDTO.firstName());
        user.setLastName(userUpdateDTO.lastName());

        String newEmail = userUpdateDTO.email();
        if (userRepository.findUserByEmail(newEmail) == null) {
            user.setEmail(newEmail);
        } else {
//            give error email already in use
        }
        user.setAddress(userUpdateDTO.address());

//        if (!passwordEncoder.matches(userUpdateDTO.newPassword(), user.getPassword())) {
//            user.setPassword(passwordEncoder.encode(userUpdateDTO.newPassword()));
//        } else {
//           // gove error same pass
//        }

            mapToTestUser(testUser,user);
            userRepository.save(user);

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

    private void mapToTestUser(TestUser testUser, UserEntity user) {
        testUser.setLogged(true);
        testUser.setFirstName(user.getFirstName());
        testUser.setLastName(user.getLastName());
        testUser.setEmail(user.getEmail());
        testUser.setAddress(user.getAddress());
        testUser.setOrderCount(user.getOrders().size());
        // TODO if needs fixing
        user.getRoles().forEach(u -> {
            if (u.getName().equals(UserRoleEnum.ADMIN)) {
                testUser.setAdmin(true);

            } else {
                testUser.setAdmin(false);
            }
        });
        user.getRoles().forEach(u -> {
            if (u.getName().equals(UserRoleEnum.EMPLOYEE)) {
                testUser.setEmployee(true);
            } else {
                testUser.setEmployee(false);
            }
        });
        user.getRoles().forEach(u -> {
            if (u.getName().equals(UserRoleEnum.USER)) {
                testUser.setUser(true);
            } else {
                testUser.setUser(false);
            }
        });
    }

}



