package com.spring.dbrkd;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/mysql";
	private static final String USER = "dbrkd";
	private static final String PW = "12345";

	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		try (Connection conn = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println(conn + " <- 이게 보인다면 접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
