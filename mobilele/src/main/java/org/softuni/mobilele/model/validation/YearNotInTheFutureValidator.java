package org.softuni.mobilele.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class YearNotInTheFutureValidator implements ConstraintValidator<YearNotInTheFuture,Number> {
    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        return false;
    }
}
