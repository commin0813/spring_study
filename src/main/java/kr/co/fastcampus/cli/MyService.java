package kr.co.fastcampus.cli;


import kr.co.fastcampus.cli.validation.PersonForm;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@org.springframework.stereotype.Service
@Slf4j
public class MyService {

	@Autowired
	private Validator validator;

	public void check(){
		val personForm = new PersonForm("fastcampus",200);
		Set<ConstraintViolation<PersonForm>> result = validator.validate(personForm);

		if (result.isEmpty()){
			log.info("success");
		}else{
			log.error("fail");
		}

	}
}
