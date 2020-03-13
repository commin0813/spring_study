package kr.co.fastcampus.cli;


import kr.co.fastcampus.cli.config.AppConfig;
import kr.co.fastcampus.cli.controller.MemberController;
import kr.co.fastcampus.cli.dao.MemberDao;
import kr.co.fastcampus.cli.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@Slf4j
class Main {
	public static void main(String[] ar) throws Exception {
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("__dao.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();


		System.out.println("=================== 사용자의 username, password를 입력해주세요 =========");

		var scanner = new Scanner(System.in);
		System.out.print("username : ");
		String username = scanner.nextLine();
		System.out.print("password : ");
		String password = scanner.nextLine();
		var controllerBean = context.getBean(MemberController.class);
		controllerBean.create();
		controllerBean.insert(username,password);
		controllerBean.print();
		var serviceBean = context.getBean(MemberService.class);


		context.close();

	}
}
