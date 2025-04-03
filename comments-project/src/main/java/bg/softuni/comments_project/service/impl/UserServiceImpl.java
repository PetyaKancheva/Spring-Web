package bg.softuni.comments_project.service.impl;

import bg.softuni.comments_project.exception.UserNotFoundException;
import bg.softuni.comments_project.model.UserEntity;
import bg.softuni.comments_project.repo.UserRepository;
import bg.softuni.comments_project.service.UserService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity findByName(String name) {
        if( userRepository.findByName(name).isPresent()){
            return  userRepository.findByName(name).get();
        }

        return  createNewUserIfNotExisting(name);

    }

    private UserEntity createNewUserIfNotExisting(String name) {
        UserEntity user=new UserEntity();
               user.setName(name);
        return userRepository.save(user);
    }
}
