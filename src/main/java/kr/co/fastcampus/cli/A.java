package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
@Slf4j
public class A {
//	@Autowired
//	private B b;
	@Autowired
	private ApplicationContext context;
	@Value("#{systemProperties['hello']}")
	String property;

	@PostConstruct
	void init() {
		log.info("A post construct");
	}

	@PreDestroy
	void destory() {
		log.info("A post destory");
	}

}
