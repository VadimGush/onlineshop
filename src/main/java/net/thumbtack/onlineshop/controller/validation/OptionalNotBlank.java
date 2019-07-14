package net.thumbtack.onlineshop.controller.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = OptionalNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OptionalNotBlank {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}