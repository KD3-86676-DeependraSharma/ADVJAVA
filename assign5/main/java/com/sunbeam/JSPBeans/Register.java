package com.sunbeam.JSPBeans;

import java.sql.Date;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class Register {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String dob;
	int count;
	
	
	public Register() {
		super();
	}
	
	public Register(String firstName, String lastName, String email, String password, String dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public void registerUser() {
		
		Date d=Date.valueOf(dob);
		
		User u=new User(0,firstName,lastName,email,password,d,0,"voter"); 
		try(UserDao userDao =new UserDaoImpl() ){
			
			count=userDao.save(u);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
