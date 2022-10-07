package com.julianduru.util.exception;


import com.google.common.base.Strings;
import com.julianduru.util.CryptoUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * created by julian on 28/02/2021
 */
@Slf4j
public class RuntimeServiceException extends RuntimeException implements CodedException {


    protected int code = 1000000;


    public RuntimeServiceException() {
        super();
        setCode();
    }


    public RuntimeServiceException(String message) {
        super(message);
        setCode();
    }


    public RuntimeServiceException(String message, Throwable cause) {
        super(message, cause);
        setCode();
    }


    public RuntimeServiceException(Throwable cause) {
        super(cause);
        setCode();
    }


    public static RuntimeServiceException of(Throwable cause) {
        log.error(cause.getMessage(), cause);
        return new RuntimeServiceException(cause);
    }


    @Override
    public String getMessage() {
        String message = super.getMessage();

        try {
            // TODO: fix this potentially problematic logic
            if (!Strings.isNullOrEmpty(message) && message.contains(":")) {
                message = message.substring(message.indexOf(":") + 2);
            }
        }
        catch (IndexOutOfBoundsException e) {
            log.error(e.getMessage(), e);
        }

        return message;
    }


    public Integer generateCode() {
        byte[] classNameBytes = getClass().getName().getBytes();
        return Math.abs(CryptoUtil.hashBytes(classNameBytes));
    }


    private void setCode() {
        this.code = generateCode();
    }


    public int getCode() {
        return code;
    }



}

