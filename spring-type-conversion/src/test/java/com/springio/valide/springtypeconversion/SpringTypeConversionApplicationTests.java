package com.springio.valide.springtypeconversion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTypeConversionApplicationTests {


	@Test
	public void contextLoads() {
		DefaultConversionService cs = new DefaultConversionService();
		//转换集合
		List<Integer> input =  Stream.of(1,2,3,4).collect(Collectors.toList());
		List<String> list = (List<String>)cs.convert(input,
				TypeDescriptor.forObject(input), // List<Integer> type descriptor
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(String.class)));
		list.stream().forEach(System.out::println);
		//转换普通类型
		String s = "10";
		System.out.println(cs.convert(s,Integer.class));



	}

}
