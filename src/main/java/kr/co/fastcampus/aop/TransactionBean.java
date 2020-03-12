package kr.co.fastcampus.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@Aspect
public class TransactionBean {
	private Connection connection;

	public TransactionBean(Connection connection) {
		this.connection = connection;

	}

	@Pointcut("execution(* kr.co.fastcampus.cli.Dao.*(..))")
	public void transactionPointCut(){

	}

	@Around("transactionPointCut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws SQLException {
		log.error(">>> before aop transaction");
		var statement = connection.createStatement();
		connection.setAutoCommit(false);
		try {
			Object proceed = pjp.proceed();
			connection.commit();
			log.error(">> commit");
			return proceed;
		} catch (Throwable throwable) {
			connection.rollback();
			log.error(">> rollback");
		}
		log.error(">>> after aop log");
		return null;
	}
}
