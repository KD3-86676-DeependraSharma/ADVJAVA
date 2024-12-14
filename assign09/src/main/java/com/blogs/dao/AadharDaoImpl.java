package com.blogs.dao;

import static com.blogs.utils.HibernateUtils.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.blogs.pojos.AadharCard;
import com.blogs.pojos.User;

public class AadharDaoImpl implements AadharDao {

	@Override
	public String assignUserAadhar(Long userId, AadharCard newAdr) {
		String msg="Aadhar not assigned...";
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			User userid=session.get(User.class, userId);
			if(userId!=null) {
				userid.addAadhar(newAdr);
				msg="Address assigned successfully.....";
			}
			tx.commit();
			
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}


}
