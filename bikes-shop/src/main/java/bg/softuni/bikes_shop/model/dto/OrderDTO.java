package bg.softuni.bikes_shop.model.dto;




import java.util.List;


public record OrderDTO(
        String buyer,
        List<ItemDTO> items,
        Double totalSum) {

        public static OrderDTO empty(){
                return new OrderDTO(null,null,null);
        }
}
