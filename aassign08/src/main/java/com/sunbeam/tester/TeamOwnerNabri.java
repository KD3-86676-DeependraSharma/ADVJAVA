package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.Dao.TeamDao;
import com.sunbeam.Dao.TeamDaoImpl;

public class TeamOwnerNabri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(SessionFactory sf=getSessionFactory();Scanner sc=new Scanner(System.in)){

			TeamDao teamDao=new TeamDaoImpl();
			System.out.println("Enter max age and batting avg :");
			teamDao.getTeamOwnerNabri(sc.nextInt(), sc.nextDouble()).forEach(System.out::println);
		}
		catch (RuntimeException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
