package kr.co.fastcampus.cli.validation;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@Slf4j
public class PersonForm {
	@NotNull
	@Size(max=64) String name;
	@Size(min=0) int age;
}
