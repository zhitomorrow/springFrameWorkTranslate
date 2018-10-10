package com.springio.ioctest.eventpublishannoationtest.po;

import com.springio.ioctest.eventpublishannoationtest.event.ListUpdateEvent;
import org.springframework.context.event.EventListener;

public class ListUpdateEventNotifier   {

    @EventListener
    public void processListUpdateEvent(ListUpdateEvent event){
        System.out.println("监测到listUpdateEvent事件："+event.getContent());
    }


}
