package com.blogs.tester;
import static com.blogs.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.blogs.dao.AadharDao;
import com.blogs.dao.AadharDaoImpl;
import com.blogs.pojos.AadharCard;
public class AssignUserAadhar {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getSessionFactory();Scanner sc=new Scanner(System.in)){
			
			System.out.println("Enter User_id");
			Long userid=sc.nextLong();
			System.out.println("Enter Aadhar_ID and location :");
			AadharCard adr=new AadharCard(sc.next(),sc.next());
			AadharDao aadharDao=new AadharDaoImpl();
			System.out.println(aadharDao.assignUserAadhar(userid, adr));
		}catch (RuntimeException e) {
            e.printStackTrace();
		}

	}

}
