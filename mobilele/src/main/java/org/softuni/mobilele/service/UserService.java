package org.softuni.mobilele.service;

import org.softuni.mobilele.model.dto.UserLoginDTO;
import org.softuni.mobilele.model.dto.UserRegistrationDTO;
import org.springframework.stereotype.Service;

public interface UserService {
    void registerUser(UserRegistrationDTO userRegistrationDTO);
    void loginUser(UserLoginDTO userLoginDTO);
    void logOutUser();

}
