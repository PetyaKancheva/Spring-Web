package bg.softuni.bikes_shop.service;

import bg.softuni.bikes_shop.model.UserRoleEnum;
import bg.softuni.bikes_shop.model.dto.ItemDTO;
import bg.softuni.bikes_shop.model.dto.OrderDTO;
import bg.softuni.bikes_shop.model.entity.*;
import bg.softuni.bikes_shop.repository.OrderRepository;
import bg.softuni.bikes_shop.repository.UserRepository;
import bg.softuni.bikes_shop.service.impl.ItemServiceImpl;
import bg.softuni.bikes_shop.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {
    private static final String EMAIL = "test@mail.com";
    private static final String ORDER_STATUS = "open";
    private static final Double TOTAL_SUM = 1000.d;
    private OrderServiceImpl orderServiceTest;
    private ItemServiceImpl itemServiceTest;
    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private OrderRepository mockOrderRepository;
    @Mock
    private UserEntity mockUser;
    @Mock
    private ProductEntity mockProduct;


    @BeforeEach
    void setUp() {
        orderServiceTest = new OrderServiceImpl(mockUserRepository, mockOrderRepository, itemServiceTest);

    }

    @Test
    void testGetAllWithOneOrderSuccess() {
        // for oneORder First?
        // for multiple orders
        //arrange
        int itemsCount=2;
        int ordersCount=2;
       List< OrderEntity> testOrders = createListOrderEntity(ordersCount,itemsCount);

        when(mockOrderRepository.findAllByBuyerEmail(EMAIL).stream().toList())
                .thenReturn(testOrders);
//act
        List<OrderDTO> result = orderServiceTest.getAllByUser(EMAIL);
//
//        //assert

        Assertions.assertNotNull(result);
        Assertions.assertEquals(TOTAL_SUM,result.getFirst().totalSum()) ;
        Assertions.assertEquals(itemsCount,result.getFirst().items().size()) ;
        Assertions.assertEquals(ordersCount,result.size()) ;
       Assertions.assertEquals(TOTAL_SUM,result.getFirst().items().s);

    }
    private List<OrderEntity> createListOrderEntity(int orderCount,int itemsCount) {

        List<OrderEntity> mockOrders = new ArrayList<>();
        for (int i = 0; i < orderCount; i++) {
            mockOrders.add(createTestOrderEntity(itemsCount));
        }
        return  mockOrders;
    }
    private OrderEntity createTestOrderEntity(int itemsCount) {

        return new OrderEntity()
                .setBuyer(mockUser)
//                .setDateCreated(LocalDate.now())// TODO fix
//                .setStatus(ORDER_STATUS)
                .setTotalSum(BigDecimal.valueOf(TOTAL_SUM))
                .setItems(createListItemEntity(itemsCount));

    }


    private List<ItemEntity> createListItemEntity(int itemsCount) {

        List<ItemEntity> mockItems = new ArrayList<>();
        for (int i = 0; i < itemsCount; i++) {
            mockItems.add(createTestItemEntity());
        }
        return  mockItems;
    }
    private ItemEntity createTestItemEntity(){
       return new ItemEntity().setProduct(mockProduct);

    }
}