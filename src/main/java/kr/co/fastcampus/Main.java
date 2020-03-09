package kr.co.fastcampus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] ar) throws ClassNotFoundException {
		logger.debug("Hello World");
		Class.forName("org.h2.Driver");
		var url = "jdbc:h2:mem:test;MODE=MySql";

		try (var connection = DriverManager.getConnection(url, "sa", "");
			var statement = connection.createStatement();
		) {
			connection.setAutoCommit(false);

			statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null,primary key(id))");
			try{
				statement.executeUpdate("insert into member(username,password) values('admin','1234')");
				connection.commit();
			}catch (Exception e){
				connection.rollback();
			}

			var resultSet = statement.executeQuery("select id,username,password from member");
			while (resultSet.next()) {
				Member member = new Member(resultSet);
				logger.debug(member.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
