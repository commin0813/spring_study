package kr.co.fastcampus.cli.controller;

import kr.co.fastcampus.cli.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

@Slf4j
@AllArgsConstructor
public class MemberController {
	private MemberService memberService;

	public void create() {
		try {
			memberService.create();
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
	}

	public void insert(String userName,String password)  {
		try {
			memberService.insert(userName,password);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
	}

	public void print() {
		try {
			memberService.print();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
