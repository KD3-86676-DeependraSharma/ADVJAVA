package com.sunbeam.tester;


import org.hibernate.SessionFactory;

import com.sunbeam.Dao.TeamDao;
import com.sunbeam.Dao.TeamDaoImpl;
import com.sunbeam.entities.Team;
import com.sunbeam.utils.HibernateUtils;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;


import java.util.Scanner;

public class TeamRegister {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create user dao instance
			TeamDao userDao=new TeamDaoImpl();
			System.out.println("Enter Teams details : name=\" + name + \", abbreviation=\" + abbreviation + \", owner=\" + owner\r\n"
					+ "				+ \", age=\" + age + \", battingAvg=\" + battingAvg + \", wicketTaken=\" + wicketTaken ");
//			Team newUser=new Team(sc.next(), sc.next(), sc.next(), sc.nextInt(),sc.nextDouble(), sc.nextInt());
//			System.out.println(userDao.signUpTeam(newUser));
			
			Team newUser = new Team(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
			System.out.println(userDao.signUpTeam(newUser));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
