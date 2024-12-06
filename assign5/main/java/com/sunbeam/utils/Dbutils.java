package com.sunbeam.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbutils {

	public static final String DB_Driver="com.mysql.cj.jdbc.Driver";
//	public static final String DB_URL="jdbc:mysql://localhost:3306//advjavapractice";
	public static final String DB_URL="jdbc:mysql://localhost:3306/advjavapractice";
	public static final String DB_User="root";
	public static final String DB_Password="manager";
	
	
	static {
		try {
			Class.forName(DB_Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}
	public static Connection getConnection()throws Exception{
		Connection con=DriverManager.getConnection(DB_URL,DB_User,DB_Password);
		return con;
	}

	
}
