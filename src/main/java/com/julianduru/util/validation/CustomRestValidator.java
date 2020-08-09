package com.julianduru.util.validation;


import org.springframework.validation.Validator;

import java.util.Set;

/**
 * created by julian
 */
public interface CustomRestValidator extends Validator {


    Set<String> getEvents();


}
