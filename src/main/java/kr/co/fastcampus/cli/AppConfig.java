package kr.co.fastcampus.cli;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {


	@Bean
	@Primary
	public ExamB b1(){
		return new ExamB();
	}

	@Bean
	public ExamB b2(){
		return new ExamB();
	}

//	@Bean
//	public ExamA b2(){
//		return new ExamA();
//	}
}
