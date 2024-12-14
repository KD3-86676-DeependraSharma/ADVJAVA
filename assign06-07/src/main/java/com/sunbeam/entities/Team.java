package com.sunbeam.entities;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="teams")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="team_id")
	private Long teamid;
	@Column(length = 100, name="name", unique = true)
	private String name;
	@Column(length = 10, name="abbreviation", unique = true)
	private String abbreviation;
	@Column(length = 20, name="owner", nullable = false)
	private String owner;
	@Column(length = 20, name="max_plater_age")
	private int age;
	@Column(length = 20, name="batting_avg")
	private double battingAvg;
	@Column(length = 20, name="wickets_taken")
	private int wicketTaken;
	
	
	public Team() {
	}


	

	
	public Team(String abbreviation, String owner) {
		super();
		this.abbreviation = abbreviation;
		this.owner = owner;
	}





	public Team(String name, String abbreviation, String owner, int age, double battingAvg, int wicketTaken) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.age = age;
		this.battingAvg = battingAvg;
		this.wicketTaken = wicketTaken;
	}


	public Long getTeamid() {
		return teamid;
	}


	public void setTeamid(Long teamid) {
		this.teamid = teamid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAbbreviation() {
		return abbreviation;
	}


	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getBattingAvg() {
		return battingAvg;
	}


	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}


	public int getWicketTaken() {
		return wicketTaken;
	}


	public void setWicketTaken(int wicketTaken) {
		this.wicketTaken = wicketTaken;
	}


	@Override
	public String toString() {
		return "Team [teamid=" + teamid + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", age=" + age + ", battingAvg=" + battingAvg + ", wicketTaken=" + wicketTaken + "]";
	}
	
	
	
}
