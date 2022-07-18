package com.julianduru.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * created by julian on 18/07/2022
 */
@Slf4j
public class StringUtilTest {

    @Test
    public void testStringifyingList() {
        var list = List.of(
            "ADMIN", "USER"
        );
        var output = StringUtil.stringifyList(list, "\\\\\"");
        log.info(output);
    }

}


