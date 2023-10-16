package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.DTO.UserLoginDTO;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void loginUser(UserLoginDTO userLoginDTO){
        userRepository.save(map(userLoginDTO));

    }

    private User map(UserLoginDTO userLoginDTO){
        return new User().setUsername(userLoginDTO.username()).setPassword(userLoginDTO.password())
                ;

    }

}
