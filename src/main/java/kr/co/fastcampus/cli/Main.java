package kr.co.fastcampus.cli;


import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
class Main {
	public static void main(String[] ar) throws Exception {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.scan("kr.co.fastcampus.cli");
//		context.refresh();
//		val b = context.getBean(B.class);
//		log.info(""+b);
		val dao = context.getBean(Dao.class);
		dao.run();
		context.close();

	}
}
