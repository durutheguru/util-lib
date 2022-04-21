package com.julianduru.util.validation.impl;


import com.julianduru.util.validation.URLCollection;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.net.MalformedURLException;
import java.util.Collection;

public class UrlCollectionValidator implements ConstraintValidator<URLCollection, Collection<String>> {


    @Override
    public void initialize(URLCollection constraint) {

    }

    @Override
    public boolean isValid(Collection<String> urls, ConstraintValidatorContext context) {
        for (String url : urls) {
            try {
                new java.net.URL(url);
            } catch (MalformedURLException var5) {
                return false;
            }
        }

        return true;
    }



}

