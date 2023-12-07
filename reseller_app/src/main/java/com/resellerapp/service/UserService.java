package com.resellerapp.service;

import com.resellerapp.model.LoginDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean login(LoginDTO loginDTO);
}
