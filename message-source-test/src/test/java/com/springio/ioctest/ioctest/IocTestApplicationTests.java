package com.springio.ioctest.ioctest;

import com.springio.ioctest.ioctest.config.ExceptionSourceConfig;
import com.springio.ioctest.ioctest.config.MessageSourceConfig;
import com.springio.ioctest.ioctest.pojo.Example;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IocTestApplicationTests {

	@Test
	@Ignore
	public void contextLoads() {
		MessageSource source = new AnnotationConfigApplicationContext(MessageSourceConfig.class);
		String message = source.getMessage("message",null,"Default",null);
		System.out.println(message);
	}

	@Test
	public void test() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExceptionSourceConfig.class);
		Example e = (Example) applicationContext.getBean("example");
		e.execute();

	}

}
