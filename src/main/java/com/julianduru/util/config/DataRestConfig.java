package com.julianduru.util.config;


import com.julianduru.util.validation.ValidationRegistrar;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * created by julian
 */
@Configuration
@RequiredArgsConstructor
public class DataRestConfig implements RepositoryRestConfigurer {


    final LocalValidatorFactoryBean validatorFactoryBean;


    final ValidationRegistrar validationRegistrar;



    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", validatorFactoryBean);
        validatingListener.addValidator("beforeSave", validatorFactoryBean);

        validationRegistrar.registerValidators(validatingListener);
    }



}
