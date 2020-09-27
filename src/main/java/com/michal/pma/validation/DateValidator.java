package com.michal.pma.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class DateValidator implements ConstraintValidator<CorrectDate , Date> {

    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if(value == null){
            return false;
        }
        return true;
    }
}
