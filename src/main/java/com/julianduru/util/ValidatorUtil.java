package com.julianduru.util;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.*;
import java.util.Set;

/**
 * created by julian
 */
public class ValidatorUtil {


    static Logger log = LoggerFactory.getLogger(ValidatorUtil.class);


    private static <T> Set<ConstraintViolation<T>> getConstraintViolations(T item) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        return validator.validate(item);
    }


    public static <T> void validate(T item) throws ValidationException {
        Set<ConstraintViolation<T>> violations = getConstraintViolations(item);
        if (!violations.isEmpty()){
            throw new ValidationException(violations.iterator().next().getMessage());
        }
    }


    public static <T> boolean isValid(T item) {
        Set<ConstraintViolation<T>> violations = getConstraintViolations(item);
        return violations.isEmpty();
    }


    public static <T> void testValid(T item) {
        assert isValid(item);
    }


}
