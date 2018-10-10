package com.springio.ioctest.eventpublishannoationtest;

import com.springio.ioctest.eventpublishannoationtest.config.MyConfig;
import com.springio.ioctest.eventpublishannoationtest.po.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventPublishAnnoationTestApplicationTests {

	@Test
	public void contextLoads() {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		EmailService email = (EmailService)context.getBean("emailService");
		//email.sendEmail("known.spammer@example.org","aaaaaa");//此时不满足content=my-event，因此事件不会被监听到
		email.sendEmail("known.spammer@example.org","my-event");
	}

}
