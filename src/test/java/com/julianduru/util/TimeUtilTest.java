package com.julianduru.util;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

/**
 * created by julian
 */
@Slf4j
public class TimeUtilTest {


    @Test
    @Disabled
    public void testDeserializingZonedDateTimeString() throws Exception {
        log.info("Deserialized Time: {}", TimeUtil.parseZonedDateTime(
            "2021-05-13 10:40:45.4591 +0100"
        ));
        log.info("Deserialized Time: {}", TimeUtil.parseZonedDateTime(
            "2021-04-28 12:54am +0100"
        ));
    }


    @Test
    public void testSerializingZonedDateTimeString() throws Exception {
        var time = ZonedDateTime.now();
        log.info("Serialized Time: {}", time.format(TimeUtil.DEFAULT_ZONE_DATE_TIME_FORMATTER));
    }



}

