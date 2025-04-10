package bg.softuni.bikes_shop.service;

import bg.softuni.bikes_shop.model.UserRoleEnum;
import bg.softuni.bikes_shop.model.dto.OrderDTO;
import bg.softuni.bikes_shop.model.entity.*;
import bg.softuni.bikes_shop.repository.ItemRepository;
import bg.softuni.bikes_shop.repository.OrderRepository;
import bg.softuni.bikes_shop.repository.UserRepository;
import bg.softuni.bikes_shop.service.impl.OrderServiceImpl;
import bg.softuni.bikes_shop.service.impl.UserRoleServiceImpl;
import bg.softuni.bikes_shop.util.TestDataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {
    private OrderServiceImpl orderServiceTest;
    private ItemService mockItemServiceTest;
    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private OrderRepository mockOrderRepository;


    @BeforeEach
    void setUp() {
        orderServiceTest = new OrderServiceImpl(mockUserRepository, mockOrderRepository, mockItemServiceTest);
    }

    @Test
    void testGetAllCorrectly() {
        String userEmail = "test@mail.com";

        when(mockOrderRepository.findAllByBuyerEmail(userEmail).stream().toList())
                .thenReturn(List.of(createTestOrderEntity(userEmail)));

        List<OrderDTO> result = orderServiceTest.getAllByUser("test@mail.com");
//
//        //assert

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getFirst().totalSum(), 1000);

    }

    private OrderEntity createTestOrderEntity(String email) {

        var roles = List.of(new UserRoleEntity().setName(UserRoleEnum.USER));
        OrderEntity newOrder= new OrderEntity().setBuyer(
                        new UserEntity()
                                .setEnabled(false)
                                .setFirstName("First name test")
                                .setLastName("Last name test")
                                .setEmail(email)
                                .setAddress("Address Test")
                                .setCountry("Country Test")
                                .setRoles(roles)
                                .setPassword("test1234"))
                .setDateCreated(LocalDate.now())
                .setStatus("open")
                .setTotalSum(BigDecimal.valueOf(1000));

        var items = List.of(
                new ItemEntity().setOrder(newOrder).setProduct(
                        new ProductEntity()
                                .setName("test product")
                                .setDescription("test description")
                                .setPrice(BigDecimal.valueOf(1000))
                                .setCategory("testCategory")
                                .setPictureURL("urlTest")
                        ).setQuantity(1));

        return newOrder;
    }


}