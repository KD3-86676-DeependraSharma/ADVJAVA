package com.sunbeam.Dao;

import java.util.List;
import com.sunbeam.entities.Team;

public interface TeamDao {
	//add a method to register new user
		String signUpTeam(Team team);
		//get all teams
		List<Team> getAllTeams();
		List<Team> getDisplayAllReqTeams(int age, double battingAvg);
		List<Team> getTeamOwnerNabri(int age, double battingAvg);
		String deleteTeam(Long teamid);
		String UpdateMaxAge(String name, int age, int newage);
		
}

