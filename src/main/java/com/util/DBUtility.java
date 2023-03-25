package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
	public Connection getConnection(String url,String username,String password)
	{
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
