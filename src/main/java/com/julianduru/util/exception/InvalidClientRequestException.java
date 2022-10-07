package com.julianduru.util.exception;


/**
 * created by julian
 */
public class InvalidClientRequestException extends RuntimeServiceException {


    public InvalidClientRequestException(String message) {
        super(message);
    }


    public InvalidClientRequestException(String message, Throwable cause) {
        super(message, cause);
    }


}

