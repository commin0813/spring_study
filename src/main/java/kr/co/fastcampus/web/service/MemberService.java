package kr.co.fastcampus.web.service;


import kr.co.fastcampus.web.dao.MemberDao;
import kr.co.fastcampus.web.entity.Member2;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class MemberService {
	private MemberDao memberDao;


	public void create() {
		memberDao.create();
	}

	@Transactional
	public void insert(String userName, String password) {
		memberDao.insert(userName, password);
	}

	public List<Member2> list() {
		return memberDao.list();
	}
}
