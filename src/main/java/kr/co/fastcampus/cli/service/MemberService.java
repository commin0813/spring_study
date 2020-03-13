package kr.co.fastcampus.cli.service;

import kr.co.fastcampus.cli.dao.MemberDao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Slf4j
@AllArgsConstructor
public class MemberService {
	private MemberDao memberDao;


	public void create() throws SQLException {
		memberDao.create();
	}

	@Transactional
	public void insert(String userName,String password) throws SQLException {
		memberDao.insert(userName,password);
	}

	public void print() throws Exception {
		memberDao.print();
	}
}
