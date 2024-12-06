package com.sunbeam.daos;

import java.sql.Connection;

import com.sunbeam.utils.*;

public abstract class Dao {

	protected Connection con;
	
	public Dao() throws Exception {
		con=Dbutils.getConnection();
	}
	
	public void close()throws Exception {
		con.close();
	}
}