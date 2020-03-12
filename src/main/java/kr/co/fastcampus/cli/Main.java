package kr.co.fastcampus.cli;


import kr.co.fastcampus.aop.TransactionBean;
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
		context.register(TransactionBean.class);
		context.refresh();
		//context.getEnvironment().setActiveProfiles("dev");
		val mysvc = context.getBean(Dao.class);
		mysvc.create();
		mysvc.insert();
		mysvc.print();
		context.close();

	}
}
