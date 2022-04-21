package com.julianduru.util.jpa;

import com.julianduru.util.TimeUtil;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.ZonedDateTime;

/**
 * created by julian on 14/04/2022
 */
@Converter
public class ZonedDateTimeStringConverter implements AttributeConverter<ZonedDateTime, String>  {


    @Override
    public String convertToDatabaseColumn(ZonedDateTime zonedDateTime) {
        return zonedDateTime.format(TimeUtil.DEFAULT_ZONE_DATE_TIME_FORMATTER);
    }


    @Override
    public ZonedDateTime convertToEntityAttribute(String s) {
        return TimeUtil.parseZonedDateTime(s);
    }


}
