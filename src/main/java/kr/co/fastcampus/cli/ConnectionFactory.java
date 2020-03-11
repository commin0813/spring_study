package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class ConnectionFactory {
    private String url;
    private String user;
    private String password;

    public ConnectionFactory(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection createConnection() throws SQLException {
        log.info("Create Connection !!");
        return DriverManager.getConnection(this.url, this.user, this.password);

    }
}
