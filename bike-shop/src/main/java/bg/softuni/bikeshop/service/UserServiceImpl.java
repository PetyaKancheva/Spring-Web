package bg.softuni.bikeshop.service;

import bg.softuni.bikeshop.model.dto.LoginUserDTO;
import bg.softuni.bikeshop.model.dto.RegisterUserDTO;
import bg.softuni.bikeshop.model.entity.UserEntity;
import bg.softuni.bikeshop.model.entity.UserRoleEntity;
import bg.softuni.bikeshop.repository.UserRepository;
import bg.softuni.bikeshop.repository.UserRoleRepository;
import bg.softuni.bikeshop.util.LoggedUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final LoggedUser loggedUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, UserRoleRepository userRoleRepository, LoggedUser loggedUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.loggedUser = loggedUser;
    }


    @Override
    public void register(RegisterUserDTO registerUserDTO) {
        UserEntity newUser = map(registerUserDTO);
        // TODO check better way to hard code USER role
        newUser.getRoles().add(userRoleRepository.findById((long) 1).orElseThrow());
        userRepository.save(newUser);


    }

    @Override
    public boolean login(LoginUserDTO loginUserDTO) {
         UserEntity userByEmail = userRepository.findByEmail(loginUserDTO.getEmail()).orElse(null);

           if(userByEmail!=null){
                loggedUser.setLogged(true);
                loggedUser.setFirstName(userByEmail.getFirstName());
                loggedUser.setLastName(userByEmail.getLastName());
                // TODO check if Admin
//                loggedUser.setAdmin(userByEmail.getRoles().contains(UserRoleEntity.g))
               return true;
           };

        return false;
    }

    private UserEntity map(RegisterUserDTO registerUserDTO) {
        return new UserEntity()
                .setEmail(registerUserDTO.getEmail())
                .setFirstName(registerUserDTO.getFirstName())
                .setLastName(registerUserDTO.getLastName())
                .setAddress(registerUserDTO.getAddress())
                .setPassword(passwordEncoder.encode(registerUserDTO.getPassword()))
                .setCreated(LocalDate.now());
    }

}
