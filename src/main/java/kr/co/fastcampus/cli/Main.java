package kr.co.fastcampus.cli;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

@Slf4j
class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] ar) throws Exception {
		logger.debug("Hello World");

//        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml", "bean.xml");
		Lifecycle lifecycle = context.getBean(Lifecycle.class);
		log.info("lifecycle is running ? --> "+ lifecycle.isRunning());
		context.close();
		log.info("lifecycle is running ? --> "+ lifecycle.isRunning());

//		ConnectionFactory connectionFactory = context.getBean("connectionFactory", ConnectionFactory.class);
//		log.info("connection created result : " + (connectionFactory.getConnection() != null));
//		for (int i = 0; i < 10; i++) {
//			System.out.println("cnt:" + i);
//			Thread.sleep(100);
//		}
//
//		context.close();


	}
}
