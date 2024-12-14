package com.sunbeam.Dao;

import com.sunbeam.entities.Team;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;
import java.util.List;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String signUpTeam(Team team) {
		String mesg="User registration failed!!!!!!!!!!";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			Serializable userId = session.save(team);
			
			tx.commit();
			mesg="User signed up ! , ID "+userId;
		}
		catch (RuntimeException e) {
			// TODO: handle exception
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public List<Team> getAllTeams() {
		String jpql="select t from Team t";
		List<Team> teams=null;
		
		Session session= getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			teams=session.createQuery(jpql,Team.class).getResultList();
			tx.commit();
		}
		catch(RuntimeException e){
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		return teams;
	}

	@Override
	public List<Team> getDisplayAllReqTeams(int age,double battingAvg){
		List<Team> teams=null;
		String jpql="select t from Team t where t.age<:ag and t.battingAvg>:batavg";
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try{
			
			teams = session.createQuery(jpql,Team.class).setParameter("ag",age ).setParameter("batavg",battingAvg).getResultList();
			tx.commit();
			
		}catch (RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		
		return teams;
		
	}

	@Override
	public List<Team> getTeamOwnerNabri(int age,double battingAvg){
		List<Team> teams=null;
		String jpql="select new com.sunbeam.entities.Team(owner,abbreviation) from Team t where t.age<:ag and t.battingAvg>:batavg";
		
        Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try{
			
			teams = session.createQuery(jpql,Team.class).setParameter("ag",age ).setParameter("batavg",battingAvg).getResultList();
			tx.commit();
			
		}catch (RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		
		return teams;	
	}
	@Override
	public String deleteTeam(Long teamid) {
		String msg="Deletion failed!!!";
		Team team=null;
		Session session=getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			team=session.get(Team.class, teamid);
			if(team!=null) {
				session.delete(team);
				msg="Team deleted successfully ...";
			}
			
			tx.commit();
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
		return msg;
		
	}
	@Override
	public String UpdateMaxAge(String name,int age,int newage) {		
	Team team=null;
	String mesg = "Password updation failed !!!!!!";
	String jpql = "select t from Team t where t.name=:nm and t.age=:ag";

	Session session = getSessionFactory().getCurrentSession();

	Transaction tx = session.beginTransaction();
	try {
		team=session.createQuery(jpql, Team.class)
				.setParameter("nm",name)
				.setParameter("ag",age)
				.getSingleResult();

		team.setAge(newage);//user -persistent
		session.evict(team);
		
		tx.commit();
		mesg="age change !";
	
	} catch (RuntimeException e) {

		if (tx != null)
			tx.rollback();
		throw e;
	}
	team.setAge(35);

			
	return mesg;
}
}
