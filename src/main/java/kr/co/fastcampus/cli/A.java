package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class A {
//	@Autowired
	private B b;
//	@Autowired
//	private ApplicationContext context;
//	@Value("#{systemProperties['hello']}")
//	String property;
	public A(B b) {
		this.b = b;
	}

	public void init() {
		log.info("A post construct");
	}

	public void destroy() {
		log.info("A post destroy");
	}

}
