package kr.co.fastcampus.aop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Service {
	public void log(){
		log.error(">> aop log");
	}

	public void beforeLog(){
		log.error(">> before log");
	}
	public void afterLog(){
		log.error(">> after log");
	}
	public void afterThrowingLog(){
		log.error(">> afterThrowingLog log");
	}
	public void afterReturningLog(){
		log.error(">> afterReturningLog log");
	}
}
