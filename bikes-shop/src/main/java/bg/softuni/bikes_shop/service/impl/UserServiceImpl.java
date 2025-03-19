package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.model.dto.UserUpdateDTO;
import bg.softuni.bikes_shop.model.entity.UserEntity;
import bg.softuni.bikes_shop.model.events.UserRegistrationEvent;
import bg.softuni.bikes_shop.repository.UserRepository;
import bg.softuni.bikes_shop.service.UserRoleService;
import bg.softuni.bikes_shop.service.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher appEventPublisher;

    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService, PasswordEncoder passwordEncoder, ApplicationEventPublisher appEventPublisher) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
        this.appEventPublisher = appEventPublisher;
    }

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {

        userRepository.save(map(userRegisterDTO));
        appEventPublisher.publishEvent(new UserRegistrationEvent(
                "UserService",userRegisterDTO.email() ,userRegisterDTO.firstName()) );
    }

    @Override
    public void update(UserUpdateDTO userUpdateDTO, String email) {

        UserEntity existingUser = userRepository.findUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with email: " + email + "not found!"));

        existingUser.setFirstName(userUpdateDTO.firstName());
        existingUser.setLastName(userUpdateDTO.lastName());

        if (userRepository.findUserByEmail(userUpdateDTO.email()) == null) {
            existingUser.setEmail(userUpdateDTO.email());
        } else {
            throw new IllegalArgumentException("User already exist with email:" + userUpdateDTO.email() + "!");
            // maybe it is themselves
        }
        existingUser.setAddress(userUpdateDTO.address());

        if (!passwordEncoder.matches(userUpdateDTO.newPassword(), existingUser.getPassword())) {
            existingUser.setPassword(passwordEncoder.encode(userUpdateDTO.newPassword()));
        } else {
            throw new IllegalArgumentException("Old password not matching!");
        }
// if old password is correct old password
//        is new pass is different than old -custom validator
        // what is old alrady wrong?

        userRepository.save(existingUser);

    }


    private UserEntity map(UserRegisterDTO userRegisterDTO) {
        return new UserEntity()
                .setLogged(false)
                .setAuthenticated(false)
                .setFirstName(userRegisterDTO.firstName())
                .setLastName(userRegisterDTO.lastName())
                .setEmail(userRegisterDTO.email())
                .setAddress(userRegisterDTO.address())
                .setCountry(userRegisterDTO.country())
                .setRoles(new HashSet<>(Arrays.asList(userRoleService.getUserRoleByName("USER"))))
                .setPassword(passwordEncoder.encode(userRegisterDTO.password()));


    }


}



