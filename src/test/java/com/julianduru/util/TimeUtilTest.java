package com.julianduru.util;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_TIME;

/**
 * created by julian
 */
@Slf4j
public class TimeUtilTest {


    @Test
    public void test() throws Exception {
        log.info("Parsed Time: {}", TimeUtil.parseZonedDateTime(
            "2021-05-13 10:40 +0100"
        ));
        log.info("Parsed Time: {}", TimeUtil.parseZonedDateTime(
            "2021-04-28 12:54am +0100"
        ));
    }


}

