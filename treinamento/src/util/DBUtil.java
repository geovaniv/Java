package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public static Connection getConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/training?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String passwords = "46128791";
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, passwords);
			return connection;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
