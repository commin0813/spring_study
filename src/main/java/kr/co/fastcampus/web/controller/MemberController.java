package kr.co.fastcampus.web.controller;


import kr.co.fastcampus.web.entity.Member2;
import kr.co.fastcampus.web.model.MemberDao;
import kr.co.fastcampus.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@RequestMapping("/index")
	public ModelAndView index() {

		ModelAndView modelAndView = new ModelAndView("index");
		List<Member2> list = memberService.list();
		modelAndView.addObject("members", list);

		return modelAndView;
	}

	@RequestMapping("/create")
	public String create(MemberDao memberDao) {
//		ModelAndView modelAndView = new ModelAndView("index");
		memberService.insert(memberDao.getUsername(), memberDao.getPassword());
		return "redirect:index";
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
