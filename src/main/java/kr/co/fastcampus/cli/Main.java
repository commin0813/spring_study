package kr.co.fastcampus.cli;


import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
class Main {
	public static void main(String[] ar) throws Exception {
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("__dao.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		//context.getEnvironment().setActiveProfiles("dev");
		val mysvc = context.getBean(MyService.class);
		mysvc.check();
		context.close();

	}
}
