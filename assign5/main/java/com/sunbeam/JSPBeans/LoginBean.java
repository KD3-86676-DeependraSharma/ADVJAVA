package com.sunbeam.JSPBeans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class LoginBean {
	private String email;
	private String password;
	private User user;
	
	int count;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LoginBean() {
		super();
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
//	public void loginValidateUser() {
//		User u=new User();
//		try(UserDao userDao=new UserDaoImpl()){
//			u=userDao.findByEmail(email);
//			
//			if(u!=null) {
//				System.out.println(u.getPassword());
//				System.out.println(password);
//				if(u.getPassword().equals(password)) {
//					count=1;
//				}
//				else {
//					count=0;
//				}
//				
//			}
//			else {
//				count=0;
//			}
//			
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	public void loginValidateUser() {
//		User u=new User();
//		try(UserDao userDao=new UserDaoImpl()){
//			u=userDao.findByEmail(email);
//			
//			if(u!=null) {
//				System.out.println(u.getPassword());
//				System.out.println(password);
//				if(u.getPassword().equals(password)) {
//					count=1;
//					this.user=u;
//				}
//				else {
//					count=0;
//					this.user=null;
//				}
//				
//			}
//			else {
//				count=0;
//				this.user=null;
//			}
//			
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void loginValidateUser() {
		try(UserDao userDao = new UserDaoImpl()) {
			User dbUser = userDao.findByEmail(this.email);
			if(dbUser != null && dbUser.getPassword().equals(this.password))
				this.user = dbUser;
			else
				this.user = null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
