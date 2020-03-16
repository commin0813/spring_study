package kr.co.fastcampus.web.service;


import kr.co.fastcampus.web.dao.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import kr.co.fastcampus.web.entity.*;

@Slf4j
@AllArgsConstructor
public class MemberService {
	private MemberDao memberDao;


	public void create() {
		memberDao.create();
	}

	@Transactional
	public void insert(String userName,String password) {
		memberDao.insert(userName,password);
	}

	public List<Member> list() {
		return memberDao.list();
	}
}
