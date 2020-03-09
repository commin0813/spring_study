package kr.co.fastcampus.cli;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

@Slf4j
public class Dao {

//    public static Dao createDao() {
//        log.info("CreateDao");
//        return new Dao();
//    }

    public void run() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        var url = "jdbc:h2:mem:test;MODE=MySql";

        try (var connection = DriverManager.getConnection(url, "sa", "");
             var statement = connection.createStatement();
        ) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
