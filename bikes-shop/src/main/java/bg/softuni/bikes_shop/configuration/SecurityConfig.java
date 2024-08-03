package bg.softuni.bikes_shop.configuration;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;





public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//       return httpSecurity.authorizeHttpRequests(
//                authorizeRequests -> authorizeRequests
//                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                        .requestMatchers("/", "/login", "/registration").permitAll()
//                        .anyRequest().authenticated()
//        ).formLogin(
//                formLogin -> formLogin
//                        .loginPage("/login")
//                        .usernameParameter("email")
//                        .passwordParameter("password")
//                        .defaultSuccessUrl("/", true)
//                        .failureForwardUrl("/about")
//        ).logout(
//                logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/")
//                        .invalidateHttpSession(true)
//        ).build();
//
//    }
}
