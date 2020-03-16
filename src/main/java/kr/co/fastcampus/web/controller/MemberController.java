package kr.co.fastcampus.web.controller;


import kr.co.fastcampus.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import kr.co.fastcampus.web.entity.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@RequestMapping("/index")
	public ModelAndView index(){

		ModelAndView modelAndView = new ModelAndView("index");
		List<Member> list = memberService.list();
		modelAndView.addObject("members",list);

		return modelAndView;
	}

	@RequestMapping("/create")
	public void create(){
		memberService.insert("userName","password");
	}


//
//	public void create() {
//		try {
//			memberService.create();
//		} catch (SQLException e) {
//			log.error(e.getMessage());
//		}
//	}
//
//	public void insert(String userName,String password)  {
//		try {
//			memberService.insert(userName,password);
//		} catch (SQLException e) {
//			log.error(e.getMessage());
//		}
//	}
//
//	public void print() {
//		try {
//			memberService.print();
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
//	}
}
