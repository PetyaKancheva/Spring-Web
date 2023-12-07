package com.resellerapp.service.imp;

import com.resellerapp.model.LoginDTO;
import com.resellerapp.service.UserService;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImp implements UserService {
    @Override
    public boolean login(LoginDTO loginDTO) {
        return false;
    }
}
