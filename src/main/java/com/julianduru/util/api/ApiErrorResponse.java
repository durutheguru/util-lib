package com.julianduru.util.api;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.julianduru.util.exception.CodedException;
import com.julianduru.util.json.LocalDateTimeDeserializer;
import com.julianduru.util.json.LocalDateTimeSerializer;

import java.time.LocalDateTime;

/**
 * created by julian
 */
public class ApiErrorResponse extends ApiResponse<String> {

    public Integer code;


    @JsonIgnore
    private Exception exception;


    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
    public LocalDateTime timeStamp;


    public ApiErrorResponse() {
        super(Status.ERROR, null);
        initialize();
    }


    public ApiErrorResponse(String message) {
        super(Status.ERROR, message);
        initialize();
    }


    public ApiErrorResponse(String message, String data) {
        super(Status.ERROR, message, data);
        initialize();
    }


    public ApiErrorResponse(Exception exception) {
        super(Status.ERROR, ApiBodySanitizer.sanitizeMessage(exception));
        this.exception = exception;
        initialize();
    }


    private void initialize() {
        this.code = exception != null && exception instanceof CodedException ?
                ((CodedException)exception).getCode() : -1;
        timeStamp = LocalDateTime.now();
    }


}

