package com.pailan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	public static DbUtil dbUtil;

	private DbUtil() {

	}

	public static DbUtil getInstance() {
		if (dbUtil == null) {
			dbUtil = new DbUtil();
			System.out.println("DbUtil Created");
		}
		return dbUtil;

	}

	public Connection getDbConnection()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
//			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/project_db", "root", "ankur123");
		return connection;

	}
}
