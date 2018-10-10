package com.springio.ioctest.eventpublishannoationtest.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by B8-02 on 2018/10/10.
 */
public class BlackListEvent extends ApplicationEvent {

    private final String address;
    private final String content;

    public BlackListEvent(Object source,String address,String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }
}
