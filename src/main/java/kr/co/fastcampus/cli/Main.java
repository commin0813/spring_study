package kr.co.fastcampus.cli;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

@Slf4j

class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] ar) throws Exception {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");



	}
}
