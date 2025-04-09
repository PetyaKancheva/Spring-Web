package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.dto.AdminUpdateDTO;
import bg.softuni.bikes_shop.util.TestDataUtil;
import bg.softuni.bikes_shop.util.TestUserUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTestIT {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TestUserUtil testUserUtil;
    @Autowired
    private TestDataUtil testDataUtil;

    @BeforeEach
    void setUp() {
        testDataUtil.cleanUp();
        testUserUtil.cleanUp();
    }

    @AfterEach
    void tearDown() {
        testDataUtil.cleanUp();
        testUserUtil.cleanUp();
    }
//    @Test
//    @WithMockUser(roles = {"ADMIN"})
//    void testGet() throws Exception {
//                   mockMvc.perform(MockMvcRequestBuilders.get("/admin")
//                                   .with(csrf()))
////                            .flashAttr("adminUpdateDTO", AdminUpdateDTO.empty())).
//                    .andExpect(status().isOk());
////                    .andExpect(view().name("admin-profile"))
////                    .andExpect(model().attribute("adminUpdateDTO", AdminUpdateDTO.empty()));
//
//    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void testAdminUpdateProfileSuccess() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/admin")
                        .param("personToSearch", "tesName")
                        .with(csrf())
                )
                .andExpect(status().isOk())
                .andExpect(view().name("admin-profile"));
    }

}
