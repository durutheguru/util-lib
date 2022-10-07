package com.julianduru.util.exception;


/**
 * created by julian
 */
public class EntityNotFoundException extends RuntimeServiceException {


    public EntityNotFoundException(String entityName, Long id) {
        super(String.format("%s %d was not found.", entityName, id));
    }


    public EntityNotFoundException(String entityName, String key) {
        super(String.format("%s '%s' was not found.", entityName, key));
    }


}

