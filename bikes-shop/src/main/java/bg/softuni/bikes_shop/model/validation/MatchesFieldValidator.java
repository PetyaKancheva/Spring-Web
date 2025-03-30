package bg.softuni.bikes_shop.model.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessException;
import org.springframework.beans.PropertyAccessorFactory;

import java.util.Objects;

public class MatchesFieldValidator implements ConstraintValidator<MatchesField, Object> {

    private String first;
    private String second;
    private String message;

    @Override
    public void initialize(MatchesField constraintAnnotation) {
       this.first=constraintAnnotation.firstField();
        this.second = constraintAnnotation.secondField();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);
        Object firstProperty=beanWrapper.getPropertyValue(this.first);
        Object secondProperty=beanWrapper.getPropertyValue(this.second);
        boolean isValid= Objects.equals(firstProperty,secondProperty);
        if (!isValid) {
            context
                    .buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(second)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return  isValid;
    }
}

