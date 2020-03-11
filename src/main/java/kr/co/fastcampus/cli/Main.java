package kr.co.fastcampus.cli;


import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

@Slf4j
@Configuration

//excludeFilters : 특정 클래스를 Bean에 포함시키는것을 막는 방법들을 정의한다.
//@ComponentScan(basePackageClasses = Main.class,excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = B.class))
//@ComponentScan(basePackageClasses = Main.class,excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,pattern = "kr.co.fastcampus.cli.B"))
@ComponentScan(basePackageClasses = Main.class)
class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] ar) throws Exception {
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("__dao.xml");
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
//		val b = context.getBean(B.class);
//		log.info(""+b);
		context.close();

	}
}
