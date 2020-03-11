package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
@Slf4j
public class A implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	void init(){
		log.error(">>" + applicationContext);
		Dao d = applicationContext.getBean("dao",Dao.class);
		log.error(">>" + d);

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext  = applicationContext;
	}
}
