package com.springio.ioctest.eventpublishannoationtest.po;


import com.springio.ioctest.eventpublishannoationtest.event.BlackListEvent;
import com.springio.ioctest.eventpublishannoationtest.event.ListUpdateEvent;
import org.springframework.context.event.EventListener;

/**
 * Created by B8-02 on 2018/10/10.
 */

public class BlackListNotifier  {

    private String notificationAddress;


    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    /**
     * 监控单个事件，使用参数的方式
     * @param event
     */
    //@EventListener
    public void processBlackListEvent(BlackListEvent event) {
        // notify appropriate parties via notificationAddress...
        System.out.println("---------onApplicationEvent:"+event.getClass().getName());
        if(event instanceof BlackListEvent){
            BlackListEvent e = (BlackListEvent)event;
            System.out.println(e.getAddress()+"  "+e.getContent());
        }
    }

    /**
     * 可以同时监控多个事件，使用逗号隔开
     */
    //@EventListener({BlackListEvent.class,ContextStartedEvent.class})
    public void processBlackListEventNoArg() {
        //TODO 此处如果想要获取到event中的数据该怎么处理？暂时还不知道！
        System.out.println("没有参数的方法进行监控事件");
    }

    /**
     * 使用SpEL表达式进行过滤事件，符合条件的事件才会监听到
     * 注解的四种方式是等效的
     * @param blEvent
     */
    //@EventListener(condition = "#blEvent.content == 'my-event'")
    //@EventListener(condition = "#root.event.content == 'my-event'")
    //@EventListener(condition = "#root.args[0].content == 'my-event'")
    //@EventListener(condition = "#a0.content == 'my-event'")//也可以是#p0,0表示下标
    public void processWithCondition(BlackListEvent blEvent){
        //TODO SpEL表达式暂时还没有看到，看到后再说
        System.out.println("使用spel表达式进行事件过滤");
    }

    /**
     * 在处理BlackListEvent事件时要发布ListUpdateEvent事件，那么就将ListUpdateEvent作为方法的返回值<br/>
     * 如果要发布的是多个事件，可以返回一个事件的集合<br/>
     * 作为返回值的事件会自动发布
     * @param event
     * @return
     */
    @EventListener
    public ListUpdateEvent handleBlackListEvent(BlackListEvent event) {
        // notify appropriate parties via notificationAddress and
        // then publish a ListUpdateEvent...
        return new ListUpdateEvent(event,event.getContent());
    }


}
