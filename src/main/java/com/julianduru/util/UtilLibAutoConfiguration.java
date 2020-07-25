package com.julianduru.util;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * created by julian
 */
@Configuration
@ConditionalOnProperty(
    prefix = "code.auto-configure.util",
    name = "enabled",
    havingValue = "true",
    matchIfMissing = true
)
@ComponentScan(
    basePackages = {
        "com.julianduru.util",
    }
)
public class UtilLibAutoConfiguration {

}
