package com.sunbeam.JSPBeans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class VoteBean {
private int candId;
private boolean success;
private int userId;

public VoteBean() {
	super();
}

public int getCandId() {
	return candId;
}
public void setCandId(int candId) {
	this.candId = candId;
}
public boolean getSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public void vote() {
	this.success = false;
	try(CandidateDao candDao = new CandidateDaoImpl()){
		System.out.println(this.candId);
		int count=candDao.incrVote(candId);
		
		if(count==1) {
			try(UserDao usrDao=new UserDaoImpl()){
				System.out.println(this.userId);
				
				User u=usrDao.findById(this.userId);
				System.out.println(u);
				if(u!=null) {
					u.setStatus(1);
					count=usrDao.update(u);
					if(count==1) {
						this.success=true;
					}
				}
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//public void vote() {
//	this.success = false;
//	// increment candidate votes
//	try(CandidateDao candDao = new CandidateDaoImpl()) {
//		System.out.println(this.candId);
//		int count = candDao.incrVote(this.candId);
//		if(count == 1) {
//			// find the current user in db
//			try(UserDao userDao = new UserDaoImpl()) {
//				System.out.println(this.userId);
//				User user = userDao.findById(this.userId);
//				System.out.println(user);
//				if(user != null) {
//					// update current user status as voted
//					user.setStatus(1);
//					count = userDao.update(user);
//					if(count == 1)
//						this.success = true;
//				}
//			}
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//		throw new RuntimeException(e);
//	}
//}

}
