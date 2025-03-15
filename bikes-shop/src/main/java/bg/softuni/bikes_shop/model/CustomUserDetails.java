package bg.softuni.bikes_shop.model;

import bg.softuni.bikes_shop.model.entity.UserEntity;
import bg.softuni.bikes_shop.model.entity.UserRoleEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


public class CustomUserDetails implements  UserDetails {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private List<GrantedAuthority> authorities;


    public CustomUserDetails(UserEntity userEntity) {
        this.email = userEntity.getEmail();
        this.password = userEntity.getPassword();
        this.address=userEntity.getAddress();
        this.authorities = (userEntity.getRoles().stream().map(CustomUserDetails::mapToAuthority).toList());
        this.firstName=userEntity.getFirstName();
        this.lastName=userEntity.getLastName();
    }

    private static GrantedAuthority mapToAuthority(UserRoleEntity userRoleEntity){
        return new SimpleGrantedAuthority("ROLE_" +userRoleEntity.getName().name());

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getAddress() {
        return address;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }



}
