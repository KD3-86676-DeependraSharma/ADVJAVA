package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import org.hibernate.SessionFactory;

import com.sunbeam.Dao.TeamDao;
import com.sunbeam.Dao.TeamDaoImpl;

public class DisplayAllTeams {

	public static void main(String[] args) {
		
		try(SessionFactory sf= getSessionFactory() ) {
			TeamDao teamDao=new TeamDaoImpl();
			teamDao.getAllTeams().forEach(System.out::println);
			
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
}
