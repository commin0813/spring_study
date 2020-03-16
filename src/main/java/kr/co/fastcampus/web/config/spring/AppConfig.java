package kr.co.fastcampus.web.config.spring;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import kr.co.fastcampus.web.controller.MemberController;
import kr.co.fastcampus.web.dao.MemberDao;
import kr.co.fastcampus.web.service.MemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
//@ComponentScan(basePackageClasses = AppConfig.class)
@PropertySource("classpath:application-default.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public DataSource dataSource(@Value("${jdbc.driver-class}") String driverClass,
	                             @Value("${jdbc.url}") String url,
	                             @Value("${jdbc.user}") String user,
	                             @Value("${jdbc.password}") String password){
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driverClass);
		config.setJdbcUrl(url);
		config.setUsername(user);
		config.setPassword(password);

		return new HikariDataSource(config);
	}
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public MemberDao dao(JdbcTemplate jdbcTemplate) {
		return new MemberDao(jdbcTemplate);
	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public MemberService memberService(MemberDao memberDao){
		return new MemberService(memberDao);
	}

//	@Bean
//	public MemberController memberController(MemberService memberService){
//		return new MemberController(memberService);
//	}


//	@Bean
//	public LocalValidatorFactoryBean localValidatorFactoryBean() {
//		return new LocalValidatorFactoryBean();
//	}

}
