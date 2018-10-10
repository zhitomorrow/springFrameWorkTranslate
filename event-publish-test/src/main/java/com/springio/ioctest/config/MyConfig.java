package com.springio.ioctest.config;

import com.springio.ioctest.po.BlackListNotifier;
import com.springio.ioctest.po.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by B8-02 on 2018/10/10.
 */
@Configuration
public class MyConfig {

    @Bean
    public EmailService emailService(){
        EmailService email = new EmailService();
        email.setBlackList(Stream.of("known.spammer@example.org","known.hacker@example.org","john.doe@example.org").collect(Collectors.toList()));
        return email;
    }



    @Bean
    public BlackListNotifier blackListNotifier(){
        BlackListNotifier b = new BlackListNotifier();
        b.setNotificationAddress("blacklist@example.org");
        return b;
    }

}
