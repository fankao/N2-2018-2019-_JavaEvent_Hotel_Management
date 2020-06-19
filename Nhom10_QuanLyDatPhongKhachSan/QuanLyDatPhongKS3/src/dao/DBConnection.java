package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnect() throws Exception {
		Connection conn = null;
		String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=dbqldpKhachSan;";
		conn = DriverManager.getConnection(connUrl,"sa","123456");

		return conn;
		
	}
	
}
