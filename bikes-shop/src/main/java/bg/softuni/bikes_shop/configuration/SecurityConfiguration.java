package bg.softuni.bikes_shop.configuration;

import bg.softuni.bikes_shop.model.UserRoleEnum;
import bg.softuni.bikes_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
public class SecurityConfiguration {    private final ProductService productService;
    private final String keyRemember;

    public SecurityConfiguration(@Value ("${bikes.rememberMeKey}") String keyRemember , List<String> categories, ProductService productService) {
        this.productService = productService;
        this.keyRemember = keyRemember;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity ) throws Exception {

        httpSecurity.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/", "/login", "/register"
                                , "/services","/comments","/contacts","/about").permitAll()
                        .requestMatchers("/product/**").permitAll()
                        .requestMatchers("/{categories}", String.valueOf(productService.getDistinctCategories())).permitAll()
                        .requestMatchers("/admin").hasAuthority(UserRoleEnum.ADMIN.toString())
                        .requestMatchers("/product/add").hasAuthority(UserRoleEnum.EMPLOYEE.toString())
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin -> formLogin
                        .loginPage("/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", true)
                        .failureForwardUrl("/login-error")
        ).logout(
                logout -> logout//
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
        ).rememberMe(
                rememberMe->rememberMe // TODO if time is there to add token option instead
                        .rememberMeParameter("rememberme")
                        .key(keyRemember)
                        .rememberMeCookieName("remembermecookie")
                        .tokenValiditySeconds(604800000 )// one week in ms

        );

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

}
