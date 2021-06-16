package com.julianduru.util;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * created by julian
 */
@Slf4j
public class TimeUtilTest {


    @Test
    public void test() throws Exception {
        log.info("Parsed Time: {}", TimeUtil.parseZonedDateTime(
            "2021-05-13 10:40:45.4591 +0100"
        ));
        log.info("Parsed Time: {}", TimeUtil.parseZonedDateTime(
            "2021-04-28 12:54am +0100"
        ));
    }



}

