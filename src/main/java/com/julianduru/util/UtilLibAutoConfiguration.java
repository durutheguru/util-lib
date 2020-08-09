package com.julianduru.util;


import com.julianduru.util.config.CryptoConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
@EnableConfigurationProperties(
    value = {
        CryptoConfig.class
    }
)
public class UtilLibAutoConfiguration {

}
