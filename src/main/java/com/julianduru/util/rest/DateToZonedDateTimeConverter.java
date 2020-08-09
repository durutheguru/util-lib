package com.julianduru.util.rest;


import org.springframework.core.convert.converter.Converter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * created by julian
 */
public class DateToZonedDateTimeConverter implements Converter<Date, ZonedDateTime> {


    @Override
    public ZonedDateTime convert(Date date) {
        return ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }


}
