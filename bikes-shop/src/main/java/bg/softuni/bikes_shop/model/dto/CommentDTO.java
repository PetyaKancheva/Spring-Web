package bg.softuni.bikes_shop.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CommentDTO(
        Long id,
        @Size(min = 3, max = 15, message = "Must be between 3 and 15 characters.")
        String user_name,
        @Size(min = 3, max = 15, message = "Must be between 3 and 15 characters.")
        String title,
        @Size(min = 3, message = "Must be between at least characters.")
        String body

) {public static CommentDTO empty(){
    return  new CommentDTO(null, null,null,null);
}


}
