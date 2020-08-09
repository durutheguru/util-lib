package com.julianduru.util.validation;


import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;

/**
 * created by julian
 */
public interface ValidationRegistrar {


    void registerValidators(ValidatingRepositoryEventListener eventListener);


}
