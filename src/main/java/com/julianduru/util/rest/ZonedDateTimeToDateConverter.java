package com.julianduru.util.rest;


import org.springframework.core.convert.converter.Converter;

import java.time.ZonedDateTime;
import java.util.Date;

/**
 * created by julian
 */
public class ZonedDateTimeToDateConverter implements Converter<ZonedDateTime, Date> {


    @Override
    public Date convert(ZonedDateTime zonedDateTime) {
        return Date.from(zonedDateTime.toInstant());
    }


}

