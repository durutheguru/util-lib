package com.julianduru.util.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * created by julian
 */
@Configuration
public class UtilBeansConfig {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
