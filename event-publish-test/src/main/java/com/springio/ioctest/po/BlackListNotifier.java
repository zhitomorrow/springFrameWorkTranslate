package com.springio.ioctest.po;

import com.springio.ioctest.event.BlackListEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by B8-02 on 2018/10/10.
 */

public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

    private String notificationAddress;


    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(BlackListEvent event) {
        // notify appropriate parties via notificationAddress...
        System.out.println("onApplicationEvent:"+event.getSource());
    }



}
