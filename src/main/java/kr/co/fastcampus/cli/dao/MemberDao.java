package kr.co.fastcampus.cli.dao;

import kr.co.fastcampus.cli.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j

public class MemberDao {

	private JdbcTemplate jdbcTemplate;

	public MemberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void init(){
		log.info("Dao init");
	}
	public void destroy(){
		log.info("Dao destroy");
	}

	public void create() throws  SQLException{
//		var statement = dataSource.getConnection().createStatement();
//		statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null,primary key(id))");
		jdbcTemplate.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null,primary key(id))");
	}


	@Transactional
	public void insert(String userName,String password) throws SQLException {
//		var statement = DataSourceUtils.getConnection(jdbcTemplate).createStatement();
//		statement.executeUpdate("insert into member(username,password) values('admin','1234')");
		jdbcTemplate.update("insert into member(username,password) values(?,?)",userName,password);
	}

	public void print() throws Exception {
		List<Member> list = jdbcTemplate.query("select id,username,password from member",
				(resultSet, i) -> new Member(resultSet));

		list.forEach(x -> log.info(String.format(">>>> userName : %s, password : %s",x.getUsername(),x.getPassword())));

	}

}
