package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	public static Connection getConnection() {
		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=MockOne;integratedSecurity=true;";
		// jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks;integratedSecurity=true;

		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(dbURL);
			/*System.out.println("ok");*/
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return con;
	}
	
	public static void main(String[] args) {
		getConnection();
	}
}
