package com.julianduru.util;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * created by julian on 01/03/2021
 */
public class CryptoUtilTest {



    @Test
    public void testCryptoHashing() throws Exception {
        assertThat(CryptoUtil.hashBytes("HelloWorld".getBytes()))
            .isEqualTo(-1964593551);
        assertThat(CryptoUtil.hashBytes("HelloWorldX".getBytes()))
            .isEqualTo(-610228013);
        System.out.println("Hash: " + Math.abs(CryptoUtil.hashBytes("HelloWorldX".getBytes())));
    }


}
