package com.springio.ioctest.ioctest.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;


public class Example {

    @Autowired
    private MessageSource messages;

    public void execute() {
        String message = this.messages.getMessage("argument.required",
                new Object [] {"userDao"}, "Required", Locale.UK);
        System.out.println(message);
    }

}
