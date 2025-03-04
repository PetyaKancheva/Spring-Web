package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.model.UserRoleEnum;
import bg.softuni.bikes_shop.model.dto.UserLoginDTO;
import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.model.entity.UserEntity;
import bg.softuni.bikes_shop.model.entity.UserRoleEntity;
import bg.softuni.bikes_shop.repository.UserRepository;
import bg.softuni.bikes_shop.repository.UserRoleRepository;
import bg.softuni.bikes_shop.service.UserRoleService;
import bg.softuni.bikes_shop.service.UserService;
import bg.softuni.bikes_shop.util.TestUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
//            currentUser.login(email);

            return true;
        }
            // TODO some error msg
        return false;
    }

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {

        userRepository.save(map(userRegisterDTO));
    }

    private UserEntity map(UserRegisterDTO userRegisterDTO) {
        UserEntity newUser = new UserEntity();
        newUser.setLogged(false);
        newUser.setFirstName(userRegisterDTO.firstName());
        newUser.setLastName(userRegisterDTO.lastName());
        newUser.setEmail(userRegisterDTO.email());
        newUser.setAddress(userRegisterDTO.address());
        newUser.setRoles(new HashSet<>(Arrays.asList(userRoleService.getUserRoleByName("USER"))));
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.password()));

        return newUser;

    }
    private TestUser mapToTestUser(UserEntity user) {
        TestUser testUser = new TestUser();
        testUser.setLogged(true);
        testUser.setFirstName(user.getFirstName());
        testUser.setLastName(user.getLastName());
        testUser.setEmail(user.getEmail());
        testUser.setAddress(user.getAddress());
        testUser.setOrderCount(user.getOrders().size());
        testUser.setRoles(user.getRoles());
        return testUser;

    }

}



