package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.model.entity.UserEntity;
import bg.softuni.bikes_shop.repository.UserRepository;
import bg.softuni.bikes_shop.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        return new UserEntity()
                .setLogged(true)
                .setFirstName(userRegisterDTO.firstName())
                .setLastName(userRegisterDTO.lastName())
                .setEmail(userRegisterDTO.email())
                .setRoles(roles.a)
//                .setPassword(passwordEncoder.encode(userRegistrationDTO.password()))

                ;
    }
    }




