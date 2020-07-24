package com.julianduru.util.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * created by julian
 */
@Data
@Validated
@ConfigurationProperties(prefix = "code.config.crypto")
public class CryptoConfig {

    
    @NotEmpty(message = "Crypto Config default key should not be null")
    private String defaultKey;


    @NotEmpty(message = "Crypto Config default algorithm should not be null")
    private String defaultAlgorithm;


}
