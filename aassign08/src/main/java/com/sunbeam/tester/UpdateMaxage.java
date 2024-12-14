package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.Dao.TeamDao;
import com.sunbeam.Dao.TeamDaoImpl;
public class UpdateMaxage {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			// create user dao instance
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter TeamName , old_max_age new_old_age");
			System.out.println(teamDao.UpdateMaxAge(sc.next(), sc.nextInt(),sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
