package bg.softuni.comments_project.service;

import bg.softuni.comments_project.model.UserEntity;

import java.util.Optional;

public interface UserService {
    UserEntity findByName(String name);
}
