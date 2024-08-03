package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.model.UserRoleEnum;
import bg.softuni.bikes_shop.model.entity.UserRoleEntity;
import bg.softuni.bikes_shop.repository.UserRoleRepository;
import bg.softuni.bikes_shop.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRoleEntity getUserRoleByName(String name) {
        return userRoleRepository.findByName(UserRoleEnum.valueOf(name));
    }
}
