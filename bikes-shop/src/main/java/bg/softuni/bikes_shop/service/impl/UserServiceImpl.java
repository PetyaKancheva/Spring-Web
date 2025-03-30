package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.exceptions.CustomObjectNotFoundException;
import bg.softuni.bikes_shop.model.UserRoleEnum;
import bg.softuni.bikes_shop.model.dto.AdminUpdateDTO;
import bg.softuni.bikes_shop.model.dto.ShortUserDTO;
import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.model.dto.UserUpdateDTO;
import bg.softuni.bikes_shop.model.entity.UserEntity;
import bg.softuni.bikes_shop.model.entity.UserRoleEntity;
import bg.softuni.bikes_shop.model.events.UserRegistrationEvent;
import bg.softuni.bikes_shop.model.events.UserUpdateProfileEvent;
import bg.softuni.bikes_shop.repository.UserRepository;
import bg.softuni.bikes_shop.repository.UserRoleRepository;
import bg.softuni.bikes_shop.service.UserRoleService;
import bg.softuni.bikes_shop.service.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher appEventPublisher;
    private final EmailServiceImpl emailService;

    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService, PasswordEncoder passwordEncoder, ApplicationEventPublisher appEventPublisher, EmailServiceImpl emailService, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
        this.appEventPublisher = appEventPublisher;
        this.emailService = emailService;
    }

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        UserEntity newUserEntity = mapToEntity(userRegisterDTO);
        newUserEntity.setRoles(List.of(
                userRoleService.getUserRoleByName(UserRoleEnum.USER)
                        .orElseThrow(() -> new CustomObjectNotFoundException("User role USER not found"))));

        userRepository.save(newUserEntity);
        appEventPublisher.publishEvent(new UserRegistrationEvent(
                "UserService", userRegisterDTO.email(), userRegisterDTO.firstName()));
    }

    @Override
    public void update(UserUpdateDTO userUpdateDTO, String email) {

        UserEntity updatedUser = getUserExisting(email)
                .setFirstName(userUpdateDTO.firstName())
                .setLastName(userUpdateDTO.lastName())
                .setAddress(userUpdateDTO.address())
                .setEmail(userUpdateDTO.email())
                .setPassword(passwordEncoder.encode(userUpdateDTO.newPassword()));
        //validation
//        if (userRepository.findUserByEmail(userUpdateDTO.email()).isEmpty()) {
//            existingUser
//        } else {
//            throw new IllegalArgumentException("User already exist with email:" + userUpdateDTO.email() + "!");
//        }


//            custom validation
//        if (!passwordEncoder.matches(userUpdateDTO.newPassword(), existingUser.getPassword())) {
//            existingUser.setPassword(passwordEncoder.encode(userUpdateDTO.newPassword()));
//        } else {
//            throw new IllegalArgumentException("Old password not matching!");
//        }

        appEventPublisher.publishEvent(
                new UserUpdateProfileEvent("UserService-Update", userUpdateDTO.email(), userUpdateDTO.firstName(), String.valueOf(Instant.now())));

        userRepository.save(updatedUser);
    }

    @Override
    @EventListener(UserUpdateProfileEvent.class)
    public void notify(UserUpdateProfileEvent event) {
        emailService.sendProfileUpdateEmail(event.getUserEmail(), event.getUserFirstName(), event.getTimeOfUpdate());
        System.out.println("Notification for profile update is sent to:  " + event.getUserEmail() + " !");
    }

    @Override
    public List<ShortUserDTO> getAllByEmailFirsOrLastName(String searchWord) {

        return userRepository.findAllByEmailFirsOrLastName
                (searchWord).stream().map(UserServiceImpl::mapToShortDTO).toList();

    }

    @Override
    public Optional<AdminUpdateDTO> getAdminDTO(String email) {
        return userRepository.findUserByEmail(email).map(UserServiceImpl::mapToAdminDTO);
    }

    @Override
    public void updateByAdmin(AdminUpdateDTO adminUpdateDTO, String oldEmail) {

        UserEntity existingUser = getUserExisting(oldEmail);
        // move to validation?
        if (userRepository.findUserByEmail(adminUpdateDTO.email()).isEmpty()) {
            existingUser.setEmail(adminUpdateDTO.email());
        } else {
            throw new IllegalArgumentException("User already exist with email:" + adminUpdateDTO.email() + "!");
        }


        existingUser.getRoles().clear();
        existingUser.getRoles().addAll(getRolesFromString(adminUpdateDTO));
        existingUser.setFirstName(adminUpdateDTO.firstName());
        existingUser.setLastName(adminUpdateDTO.lastName());
        existingUser.setAddress(adminUpdateDTO.address());

        // move to validation?
//        if (!passwordEncoder.matches(adminUpdateDTO.newPassword(), existingUser.getPassword())) {
//            existingUser.setPassword(passwordEncoder.encode(adminUpdateDTO.newPassword()));
//        } else {
//            throw new IllegalArgumentException("Old password not matching!");
//        }

        appEventPublisher.publishEvent(
                new UserUpdateProfileEvent("UserService-Update", adminUpdateDTO.email(), adminUpdateDTO.firstName(), String.valueOf(Instant.now())));

        userRepository.save(existingUser);
        

    }


    private List<UserRoleEntity> getRolesFromString(AdminUpdateDTO adminUpdateDTO) {
        return adminUpdateDTO
                .roles().stream().map(role -> userRoleService.getUserRoleByName(UserRoleEnum.valueOf(role))
                        .orElseThrow(() -> new CustomObjectNotFoundException("Roles not found"))).toList();
    }

    private UserEntity getUserExisting(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with email: " + email + "not found!"));
    }

    private UserEntity mapToEntity(UserRegisterDTO userRegisterDTO) {

        return new UserEntity()
                .setEnabled(false)
                .setFirstName(userRegisterDTO.firstName())
                .setLastName(userRegisterDTO.lastName())
                .setEmail(userRegisterDTO.email())
                .setAddress(userRegisterDTO.address())
                .setCountry(userRegisterDTO.country())
                .setPassword(passwordEncoder.encode(userRegisterDTO.password()));

    }

    private static ShortUserDTO mapToShortDTO(UserEntity u) {
        return new ShortUserDTO(
                u.getEmail(),
                u.getFirstName(),
                u.getLastName());
    }

    private static AdminUpdateDTO mapToAdminDTO(UserEntity u) {
        return new AdminUpdateDTO(
                u.getRoles().stream().map(ur -> ur.getName().name()).toList(),
                u.getEmail(),
                u.getFirstName(),
                u.getLastName(),
                u.getAddress(),
                u.getCountry(),
                "dummy-password");

    }


}



