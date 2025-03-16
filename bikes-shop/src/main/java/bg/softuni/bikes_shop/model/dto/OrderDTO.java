package bg.softuni.bikes_shop.model.dto;




import jakarta.validation.constraints.NotEmpty;

import java.util.List;


public record OrderDTO(
       @NotEmpty String buyer,
        List<ItemDTO> items,
        Double totalSum) {

        public static OrderDTO empty(){
                return new OrderDTO(null,null,null);
        }
}
