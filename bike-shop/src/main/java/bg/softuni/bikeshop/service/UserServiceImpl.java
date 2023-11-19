package bg.softuni.bikeshop.service;

import bg.softuni.bikeshop.model.dto.RegisterUserDTO;
import bg.softuni.bikeshop.model.entity.UserEntity;
import bg.softuni.bikeshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{
    private static UserRepository userRepository;
    @Override
    public boolean register(RegisterUserDTO registerUserDTO) {
            userRepository.save();

    }

    private UserEntity map(RegisterUserDTO registerUserDTO){
            return new UserEntity()
                    .setEmail(registerUserDTO.getEmail())
                    .setFirstName(registerUserDTO.getFirstName())
                    .setLastName(registerUserDTO.getLastName())
                    .setAddress(registerUserDTO.getAddress())
                    .setPassword(passwordEncoder.encode(registerUserDTO.password()))
                    .setCreated(LocalDateTime.now())
                    .setRole;



    }

}
