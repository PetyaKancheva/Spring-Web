package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserLoginDTO(
        @NotEmpty
        @Email(message ="Fill in valid e-Mail")
        String email,
        @NotEmpty(message ="Password should not be empty.")
        String password) {


   public   static  UserLoginDTO empty(){
              return new UserLoginDTO(null,null );
      }

}
