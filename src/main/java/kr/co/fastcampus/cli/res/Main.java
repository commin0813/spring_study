package kr.co.fastcampus.cli.res;

import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class Main {
	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ResourceExample.class);
		context.refresh();
		val resource = context.getBean(ResourceExample.class);
		resource.print();
		context.close();





//		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
////		Resource resource = classPathXmlApplicationContext.getResource("classpath:__dao.xml");
////		Resource resource = classPathXmlApplicationContext.getResource("file:H:\\spring\\spring_study\\src\\main\\resources\\__dao.xml");
//		Resource resource = classPathXmlApplicationContext.getResource("https://www.google.com/url?sa=i&url=http%3A%2F%2Fmedia.fastcampus.co.kr%2F&psig=AOvVaw2qBkDaq4sSupe2CoaArJR0&ust=1584069209388000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMimvOb7k-gCFQAAAAAdAAAAABAD");
////		Resource resource = classPathXmlApplicationContext.getResource("classpath:__dao.xml");
//		InputStream is = resource.getInputStream();
//		byte[] bytes = is.readAllBytes();
//		System.out.println(new String(bytes));


//		var classPathResource = new ClassPathResource("__dao.xml");
//		var classPathResource = new UrlResource("file:H:\\spring\\spring_study\\src\\main\\resources\\__dao.xml");
//		var classPathResource = new FileSystemResource("H:\\spring\\spring_study\\src\\main\\resources\\__dao.xml");
//		System.out.println(classPathResource.exists());
//		if(classPathResource.exists()){
//			InputStream is = classPathResource.getInputStream();
//			byte[] bytes = is.readAllBytes();
//			System.out.println(new String(bytes));
//		}
	}
}
