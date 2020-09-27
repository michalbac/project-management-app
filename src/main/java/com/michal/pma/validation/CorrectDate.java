package com.michal.pma.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface CorrectDate {
    String message() default "Unique Constraint violated";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
