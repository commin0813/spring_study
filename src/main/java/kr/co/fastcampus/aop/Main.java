package kr.co.fastcampus.aop;

import kr.co.fastcampus.cli.Dao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		var dao = context.getBean(Dao.class);
		dao.create();
		dao.insert();
		dao.print();
		context.close();

	}
}
