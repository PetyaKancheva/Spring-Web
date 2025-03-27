package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.UserRoleEnum;
import bg.softuni.bikes_shop.model.dto.UserRegisterDTO;
import bg.softuni.bikes_shop.model.entity.UserEntity;
import bg.softuni.bikes_shop.model.entity.UserRoleEntity;

import bg.softuni.bikes_shop.repository.UserRoleRepository;
import bg.softuni.bikes_shop.service.UserRoleService;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest
@AutoConfigureMockMvc
class UserRegisterControllerTestIT {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private UserRoleService mockUserRoleService;

    @Value("${mail.port}")
    private int port;

    @Value("${mail.host}")
    private String host;

    @Value("${mail.username}")
    private String username;

    @Value("${mail.password}")
    private String password;

    private GreenMail greenMail;


    @BeforeEach
     void setUp(){
        greenMail = new GreenMail(new ServerSetup(port,host,"smtp"));
        greenMail.start();
        greenMail.setUser(username,password);



    }
    @AfterEach
    void tearDown(){
        greenMail.stop();
    }

    @Test
    void testRegistration() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .param("email","ivan@mail.com")
                .param("firstName","Ivan")
                .param("lastName","Ivanov")
                .param("address", "Sofia")
                .param("country","Bulgaria")
                .param("password","testPassword")
                .param("confirmPassword","testPassword")
                .with(csrf())
        ).andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/register"));





    }
    @Test
    void testGet(){
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/register"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private UserEntity createUserEntity() {
        return new UserEntity()
                .setLogged(true)
                .setAuthenticated(true)
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("ivan@mail.com")
                .setAddress("Sofia")
                .setCountry("Bulgaria")
                .setRoles(List.of(new UserRoleEntity().setName(UserRoleEnum.USER)))
                .setPassword("test");
    }


}