package org.softuni.mobilele.config;

import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.service.impl.MobileleUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    //TODO
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
       return httpSecurity.authorizeHttpRequests(
               authorizeRequests-> authorizeRequests
                       .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                       .requestMatchers("/","/users/login","/users/register").permitAll()
                       .anyRequest().authenticated()
       ).formLogin(
               formLogin-> {
                   formLogin.loginPage("/users/login")
                           .usernameParameter("email")
                           .passwordParameter("password")
                           .defaultSuccessUrl("/")
                           .failureForwardUrl("/users/login-error");
               }
       ).logout(
               logout->{
                   logout.logoutUrl("/users/logout")
                           .logoutSuccessUrl("/")
                           .invalidateHttpSession(true);
               }

       ).build();

    }
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository){
        return new MobileleUserDetailsService(userRepository);
    }


}
