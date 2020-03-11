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

	public void run() throws Exception {
		var statement = connection.createStatement();
		connection.setAutoCommit(false);

		statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null,primary key(id))");
		try {
			statement.executeUpdate("insert into member(username,password) values('admin','1234')");
			connection.commit();
		} catch (Exception e) {
			connection.rollback();
		}

		var resultSet = statement.executeQuery("select id,username,password from member");
		while (resultSet.next()) {
			Member member = new Member(resultSet);
			log.debug(member.toString());
		}

	}

}
