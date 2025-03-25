package bg.softuni.bikes_shop.service;



import bg.softuni.bikes_shop.exceptions.CustomObjectNotFoundException;
import bg.softuni.bikes_shop.model.entity.UserRoleEntity;
import bg.softuni.bikes_shop.repository.UserRoleRepository;
import bg.softuni.bikes_shop.service.impl.UserRoleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)

public class UserRoleServiceImplTest {
    private UserRoleServiceImpl userRoleServiceTest;


    @Mock
    private UserRoleRepository mockUserRoleRepository;

    @BeforeEach
    void setUp() {
        userRoleServiceTest = new UserRoleServiceImpl(mockUserRoleRepository);
    }


   @Test
    void testUserRoleNotFound() {
        Assertions.assertThrows( CustomObjectNotFoundException.class,
                ()-> userRoleServiceTest.getUserRoleByName("USER"));
    }

//
//    @Test
//     void testGetUserRoleByNameCorrect() {
//        //arrange
//        String testName="ADMIN";
//        UserRoleEntity testUserRoleEntity=new UserRoleEntity();
//        testUserRoleEntity.setName(UserRoleEnum.valueOf(testName));
//        testUserRoleEntity.setId(1l);
//
//
//         when(mockUserRoleRepository.findByName(testUserRoleEntity.getName())).thenReturn(
//
//        );
//        UserRoleEntity foundEntity= mockUserRoleRepository.findByName(UserRoleEnum.valueOf(testName));
//        Assert.(foundEntity );
//
//    }
}









