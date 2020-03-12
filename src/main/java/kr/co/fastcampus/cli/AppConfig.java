package kr.co.fastcampus.cli;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.sql.Connection;

@Configuration
//@ComponentScan(basePackageClasses = AppConfig.class)
@PropertySource("classpath:application-${spring.profiles.active}.properties")
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean(initMethod = "init", destroyMethod = "destroy")
	public ConnectionFactory connectionFactory(
			@Value("${jdbc.driver-class}") String driverClass,
			@Value("${jdbc.url}") String url,
			@Value("${jdbc.user}") String user,
			@Value("${jdbc.password}") String password
	) {
		ConnectionFactory connectionFactory = new ConnectionFactory(driverClass, url, user, password);
		return connectionFactory;
	}

	@Bean
	public Connection connection(ConnectionFactory connectionFactory) {
		return connectionFactory.getConnection();
	}

	@Bean
	public Dao dao(Connection connection) {
		return new Dao(connection);
	}


//	@Bean
//	public LocalValidatorFactoryBean localValidatorFactoryBean() {
//		return new LocalValidatorFactoryBean();
//	}
//
//	@Bean
//	public MyService myService() {
//		return new MyService();
//	}
}
