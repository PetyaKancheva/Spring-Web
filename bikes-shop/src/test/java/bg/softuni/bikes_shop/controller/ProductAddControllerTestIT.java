package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.model.entity.ProductEntity;
import bg.softuni.bikes_shop.model.entity.UserEntity;
import bg.softuni.bikes_shop.util.TestDataUtil;
import bg.softuni.bikes_shop.util.TestUserUtil;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.View;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductAddControllerTestIT {
    private static final String TEST_USER_EMAIL = "user@mail.com";
    private static final String TEST_EMPLOYEE_EMAIL = "employees@mail.com";
    private static final String TEST_ADMIN_EMAIL = "admin@mail.com";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TestUserUtil testUserUtil;
    @Autowired
    private TestDataUtil testDataUtil;
    @Autowired
    private View view;

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

    @Test
    @WithAnonymousUser
    void testAnonymousAddProductFails() throws Exception {
        ProductEntity product = testDataUtil.createTestProduct();
        mockMvc.perform(MockMvcRequestBuilders.post("/products/add", product)
                        .with(csrf())
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/login"));

    }

    @Test
    @WithMockUser(roles = {"EMPLOYEE"})
    void testEmployeeAddProductSuccess() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/products/add")
                        .param("name", "tesName")
                        .param("description", "Test description")
                        .param("price", "1000")
                        .param("category", "testCategory")
                        .param("pictureURL", "urlTest")
                        .with(csrf())
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/products/add"));

    }

//    @Test
//    @WithMockUser(roles = {"EMPLOYEE"})
//    void testEmployeeAddProductSuccess() throws Exception {
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/products/add",testDataUtil.createTestProductDTO())
//
//                        .with(csrf())
//                )
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/products/add"));
//
//    }

    @Test

    void tesHomePagetSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")
                        .with(csrf())
                )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));


    }
//    @Test
//    @WithUserDetails(setupBefore = TestExecutionEvent.TEST_EXECUTION)
//    public void getMessageWithUserDetails() {
//        String message = "Hi";
//
//    }


//
//    @Test
//    @WithMockUser(username = TEST_USER1_EMAIL)
//    void testNonAdminUserOwnedOffer() throws Exception {
//        UserEntity owner = userTestDataUtil.createTestUser(TEST_USER1_EMAIL);
//        OfferEntity offerEntity = testDataUtil.createTestOffer(owner);
//
//        mockMvc.perform(
//                        delete("/offer/{uuid}", offerEntity.getUuid())
//                                .with(csrf())
//                ).andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/offers/all"));
//    }
//
//    @WithMockUser(username = TEST_USER2_EMAIL)
//    @Test
//    void testNonAdminUserNotOwnedOffer() throws Exception {
//        UserEntity owner = userTestDataUtil.createTestUser(TEST_USER1_EMAIL);
//        userTestDataUtil.createTestUser(TEST_USER2_EMAIL);
//        OfferEntity offerEntity = testDataUtil.createTestOffer(owner);
//
//        mockMvc.perform(
//                delete("/offer/{uuid}", offerEntity.getUuid())
//                        .with(csrf())
//        ).andExpect(status().isForbidden());
//    }
//
//    @Test
//    @WithMockUser(
//            username = TEST_ADMIN_EMAIL,
//            roles = {"USER", "ADMIN"})
//    void testAdminUserNotOwnedOffer() throws Exception {
//        UserEntity owner = userTestDataUtil.createTestUser(TEST_USER1_EMAIL);
//        userTestDataUtil.createTestAdmin(TEST_ADMIN_EMAIL);
//        OfferEntity offerEntity = testDataUtil.createTestOffer(owner);
//
//        mockMvc.perform(
//                        delete("/offer/{uuid}", offerEntity.getUuid())
//                                .with(csrf())
//                ).andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/offers/all"));
//    }

}
