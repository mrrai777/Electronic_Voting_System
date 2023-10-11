package com.evs.util;

import java.sql.*;

public interface DBUtil {

	public static Connection getConnection() {
		Connection con = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String Host = "jdbc:mysql://localhost:3306/evs";
			con = DriverManager.getConnection(Host, "root", "root");

		} catch (ClassNotFoundException e) {

			System.out.println(e);

		} catch (SQLException e) {

			System.out.println(e);

		}
		return con;
	}
}
