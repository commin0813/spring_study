package kr.co.fastcampus.cli;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ExamA {
	@Value("${catalog.name}") String catalogName;
	@Value("#{systemProperties}")
	Map maps;
	@Value("#{systemProperties[hello]}") String property;


	// CASE 2 Variable AutoWired
	@Autowired @Qualifier("b1") private ExamB b1;
	@Autowired @Qualifier("b2") private ExamB b2;
	@PostConstruct
	public void init(){
		log.info(""+b1);
		log.info(""+catalogName);
	}

	// CASE 3 method AutoWired
//	private ExamB b;
//
//	@Autowired
//	public void setB(ExamB b) {
//		this.b = b;
//		log.info("" + b);
//	}

	// CASE 4  Bean에 주입할 객체를 정의하지 않은경우 오류내지 않으려면..
//	private ExamB b;
//
//	@Autowired(required = false)
//	public void setB(ExamB b) {
//		this.b = b;
//		log.info("" + b);
//	}
//
//	@PostConstruct
//	public void init() {
//		log.info("" + b);
//	}
}
