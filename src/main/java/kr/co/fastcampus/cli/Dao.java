package kr.co.fastcampus.cli;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

@Slf4j
public class Dao {

	private Connection connection;

	public Dao(Connection connection) {
		this.connection = connection;
	}
	public void init(){
		log.info("Dao init");
	}
	public void destroy(){
		log.info("Dao destroy");
	}

	public void create() throws  SQLException{
		var statement = connection.createStatement();
		statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null,primary key(id))");
	}

	public void insert() throws SQLException {
		var statement = connection.createStatement();
		statement.executeUpdate("insert into member(username,password) values('admin','1234')");
		throw new RuntimeException("example SQLException");
	}

	public void print() throws Exception {
		var statement = connection.createStatement();
		connection.setAutoCommit(false);

		var resultSet = statement.executeQuery("select id,username,password from member");
		while (resultSet.next()) {
			Member member = new Member(resultSet);
			log.debug(member.toString());
		}

	}

}
