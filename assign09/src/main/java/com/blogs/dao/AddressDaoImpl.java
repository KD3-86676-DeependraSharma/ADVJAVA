package com.blogs.dao;

import static com.blogs.utils.HibernateUtils.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.blogs.pojos.Address;
import com.blogs.pojos.User;

public class AddressDaoImpl implements AddressDao {

	@Override
	public String assignUserAddress(Long userId, Address newAdr) {
		String mesg="assigning adr failed !";
		// 1. get session from SF (getCurrentSession)
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			User userid=session.get(User.class, userId);
//			Address address=session.get(Address.class, newAdr); wrong
			if(userId!=null) {
				userid.addAddress(newAdr);
				mesg="Address assigned successfully.....";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}

}
