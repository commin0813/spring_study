package kr.co.fastcampus.web.entity;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Member2 {
	private int id;
	@NonNull private String username;
	@NonNull private String password;

	public Member2(ResultSet rs) throws SQLException {
		id = rs.getInt("id");
		username = rs.getString("username");
		password = rs.getString("password");
	}
//
//	public Member(int id, String username, String password) {
//		this.id = id;
//		this.username = username;
//		this.password = password;
//	}

//	@Override
//	public String toString() {
//		return String.format("id: %d , userName : %s,password:%s", id, username, password);
//	}


}
