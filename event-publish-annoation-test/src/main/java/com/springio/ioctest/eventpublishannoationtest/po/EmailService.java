package com.springio.ioctest.eventpublishannoationtest.po;

import com.springio.ioctest.eventpublishannoationtest.event.BlackListEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.List;

/**
 * Created by B8-02 on 2018/10/10.
 */

public class EmailService implements ApplicationEventPublisherAware {


    private List<String> blackList;
    private ApplicationEventPublisher publisher;


    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }




    public void sendEmail(String address, String content) {
        if (blackList.contains(address)) {
            publisher.publishEvent(new BlackListEvent(this, address, content));
            return;
        }
        // send email...
        System.out.println("send email.............");
    }
}
