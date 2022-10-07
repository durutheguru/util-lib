package com.julianduru.util.exception;


import com.google.common.base.Strings;
import com.julianduru.util.CryptoUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

/**
 * created by julian
 */
@Slf4j
public class ServiceException extends Exception implements CodedException {


    protected int code = 1000000;


    public ServiceException() {
        super();
        setCode();
    }


    public ServiceException(String message) {
        super(message);
        setCode();
    }


    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        setCode();
    }


    public ServiceException(Throwable cause) {
        super(cause);
        setCode();
    }


    public static ServiceException of(Throwable cause) {
        log.error(cause.getMessage(), cause);
        return new ServiceException(cause);
    }


    @Override
    public String getMessage() {
        String message = super.getMessage();

        try {
            if (!Strings.isNullOrEmpty(message) && message.contains(":")) {
                message = message.substring(message.indexOf(":") + 2);
            }
        }
        catch (IndexOutOfBoundsException e) {
            LoggerFactory.getLogger(ServiceException.class).error(e.getMessage(), e);
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

