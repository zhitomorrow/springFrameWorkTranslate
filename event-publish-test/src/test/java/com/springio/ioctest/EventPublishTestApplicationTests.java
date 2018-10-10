package com.springio.ioctest;

import com.springio.ioctest.config.MyConfig;
import com.springio.ioctest.po.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventPublishTestApplicationTests {

	@Test
	public void contextLoads() {
		ApplicationContext  context = new AnnotationConfigApplicationContext(MyConfig.class);
		EmailService  email = (EmailService)context.getBean("emailService");
		email.sendEmail("known.spammer@example.org","aaaaaa");

	}

}
