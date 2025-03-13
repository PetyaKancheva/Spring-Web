package bg.softuni.bikes_shop.service.impl;

import bg.softuni.bikes_shop.model.entity.UserEntity;
import bg.softuni.bikes_shop.model.entity.UserRoleEntity;
import bg.softuni.bikes_shop.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BikesUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public BikesUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity= userRepository.findUserByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("User with email: "+ email+" not found!"));
        return mapDetails((userEntity));


    }
    private static UserDetails mapDetails(UserEntity userEntity){
        return User
                .withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(userEntity.getRoles().stream().map(BikesUserDetailsService::mapToAuthority).toList())
                .build();

    }
    private static GrantedAuthority mapToAuthority(UserRoleEntity userRoleEntity){
        return new SimpleGrantedAuthority("ROLE_" +userRoleEntity.getName().name());

    }

}
