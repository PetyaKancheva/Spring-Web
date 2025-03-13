package bg.softuni.bikes_shop.configuration;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity ) throws Exception {
//
//        httpSecurity.authorizeHttpRequests(
//                authorizeRequests -> authorizeRequests
//                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                        .requestMatchers("/", "/login", "/register").permitAll()
//                        .anyRequest().authenticated()
//        ).formLogin(
//                formLogin -> formLogin
//                        .loginPage("/login")
//                        .usernameParameter("email")
//                        .passwordParameter("password")
//                        .defaultSuccessUrl("/", true)
//                        .failureForwardUrl("/login-error")
//        ).logout(
//                logout -> logout// TODO map POST request
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/")
//                        .invalidateHttpSession(true)
//        );
//
//        return httpSecurity.build();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

}
