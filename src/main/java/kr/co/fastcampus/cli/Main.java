package kr.co.fastcampus.cli;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;
@Slf4j
class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] ar) throws Exception {
		logger.debug("Hello World");

//        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml","bean.xml");
        Dao dao = context.getBean("dao",Dao.class);
        dao.run();

//        Dao2 dao2 = context.getBean("dao2",Dao2.class);
//        dao2.run();

		A a1 = context.getBean("A",A.class);
		A a2 = context.getBean("A",A.class);
		log.info("result : " + (a1 == a2));
	}
}
