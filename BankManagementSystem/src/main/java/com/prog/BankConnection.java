package com.prog;

import java.sql.Connection;
import java.sql.DriverManager;

public class BankConnection {
	
	private static Connection conn=null;
	
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/banksystem";
	private static String un="root";
	private static String up="root";
	
	
	public static Connection getConnection() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,un,up);
			if(conn==null) {
				System.out.println("Connection Error!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
	

}
