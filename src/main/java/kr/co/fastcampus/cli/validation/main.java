package kr.co.fastcampus.cli.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;


@Slf4j
public class main {
	public static void main(String[] args) {
		Person p = new Person("",200);
		PersonValidator validator = new PersonValidator();
		BindException exception =new BindException(p,"person");
		if (validator.supports(p.getClass())) {
			validator.validate(p,exception);
			log.error(">>"+exception.hasErrors());
			log.error(">>"+exception.getAllErrors());

		}else{
			log.error("Invalid class");
		}
	}
}
