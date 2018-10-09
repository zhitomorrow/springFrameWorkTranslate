package com.springio.ioctest.ioctest.config;

import com.springio.ioctest.ioctest.pojo.Example;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ExceptionSourceConfig {


    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("exceptions_en_GB");
        return source;
    }

    @Bean
    public Example example(){
        Example example = new Example();
        return example;
    }


}
