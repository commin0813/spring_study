package kr.co.fastcampus.web.dao;

import kr.co.fastcampus.web.entity.Member2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j

public class MemberDao {

	private JdbcTemplate jdbcTemplate;

	public MemberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostConstruct
	public void init() {
		log.info("Dao init");
		create();
		insert("admin", "1234");
	}

	public void destroy() {
		log.info("Dao destroy");
	}

	public void create() {
//		var statement = dataSource.getConnection().createStatement();
//		statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null,primary key(id))");
		jdbcTemplate.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null,primary key(id))");
	}


	@Transactional
	public void insert(String userName, String password) {
//		var statement = DataSourceUtils.getConnection(jdbcTemplate).createStatement();
//		statement.executeUpdate("insert into member(username,password) values('admin','1234')");
		jdbcTemplate.update("insert into member(username,password) values(?,?)", userName, password);
	}

	public List<Member2> list() {
		return jdbcTemplate.query("select id,username,password from member",
				(resultSet, i) -> new Member2(resultSet));

//		list.forEach(x -> log.info(String.format(">>>> userName : %s, password : %s",x.getUsername(),x.getPassword())));

	}

}
