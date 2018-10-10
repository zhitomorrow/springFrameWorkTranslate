package com.springio.ioctest.eventpublishannoationtest.event;

import org.springframework.context.ApplicationEvent;

public class ListUpdateEvent extends ApplicationEvent{

    private String content ;

    public ListUpdateEvent(Object source,String content) {
        super(source);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
