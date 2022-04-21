package com.julianduru.util.validation;

import com.julianduru.util.validation.impl.UrlCollectionValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UrlCollectionValidator.class)
public @interface URLCollection {

    String message() default "URL pattern mismatch";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
