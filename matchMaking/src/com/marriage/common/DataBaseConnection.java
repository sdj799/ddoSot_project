package com.marriage.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	
	private DataBaseConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static DataBaseConnection Connection = new DataBaseConnection();
	
	public static DataBaseConnection getInstance() {
		return Connection;
	}
	
	public Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "hr";
		String upw = "hr";
		return DriverManager.getConnection(url, uid, upw);
	}
}
