package com.julianduru.util.jpa;

import com.julianduru.util.TimeUtil;
import org.springframework.util.StringUtils;

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
        if (zonedDateTime != null) {
            return zonedDateTime.format(TimeUtil.DEFAULT_ZONE_DATE_TIME_FORMATTER);
        }

        return null;
    }


    @Override
    public ZonedDateTime convertToEntityAttribute(String s) {
        if (StringUtils.hasText(s)) {
            return TimeUtil.parseZonedDateTime(s);
        }

        return null;
    }


}
