package bg.softuni.bikes_shop.model.validation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy=MatchesFieldValidator.class)
public @interface MatchesField  {

    String firstField();
    String secondField();
    String message() default "Must match second field";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
