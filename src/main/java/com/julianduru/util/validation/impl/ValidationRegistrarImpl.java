package com.julianduru.util.validation.impl;


import com.julianduru.util.validation.CustomRestValidator;
import com.julianduru.util.validation.ValidationRegistrar;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * created by julian
 */
@Component
@RequiredArgsConstructor
public class ValidationRegistrarImpl implements ValidationRegistrar {


    private final List<CustomRestValidator> validators;


    @Override
    public void registerValidators(ValidatingRepositoryEventListener eventListener) {
        for (CustomRestValidator validator : validators) {
            validator.getEvents().stream().forEach(
                e -> eventListener.addValidator(e, validator)
            );
        }
    }


}
