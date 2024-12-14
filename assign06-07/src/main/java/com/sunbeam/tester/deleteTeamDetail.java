package com.sunbeam.tester;

import java.util.Scanner;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;
import org.hibernate.SessionFactory;

import com.sunbeam.Dao.TeamDao;
import com.sunbeam.Dao.TeamDaoImpl;

public class deleteTeamDetail {

	public static void main(String[] args) {
		 
		try (SessionFactory sf=getSessionFactory();Scanner sc=new Scanner(System.in)){
			TeamDao teamDao=new TeamDaoImpl();
			System.out.println("Enter team id :");
			System.out.println(teamDao.deleteTeam(sc.nextLong()));
		}	
	}

}
