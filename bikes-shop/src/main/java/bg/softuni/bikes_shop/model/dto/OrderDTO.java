package bg.softuni.bikes_shop.model.dto;

import bg.softuni.bikes_shop.model.entity.ItemsEntity;
import bg.softuni.bikes_shop.model.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.criteria.Order;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record OrderDTO(
        String buyer,
        List<ItemDTO> items,
        Double totalSum) {

        public static OrderDTO empty(){
                return new OrderDTO(null,null,null);
        }
}
