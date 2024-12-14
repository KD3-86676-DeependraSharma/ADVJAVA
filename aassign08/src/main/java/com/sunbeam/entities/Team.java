package com.sunbeam.entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//JPA annotation
@Entity
@Table(name="teams")
//lombok annitation 
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Team extends BaseEntity{
	@Column(length = 100, unique =true )
	private String name;
	@Column(length = 10)
	private String abbreviation;
	@Column(length = 20, unique = true, nullable = false)
	private String owner;
	@Column(name="max_player_age")
	private int age;
	@Column(length = 20, name="batting_avg")
	private double battingAvg;
	@Column(length = 20, name="wickets_taken")
	private int wicketTaken;
	
	@OneToMany(mappedBy = "team")
	List<Player> players = new ArrayList<>();
	
    
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





	public Team(String name, String abbreviation, String owner, int age, double battingAvg, int wicketTaken,
			List<Player> players) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.age = age;
		this.battingAvg = battingAvg;
		this.wicketTaken = wicketTaken;
		this.players = players;
	}


	
	
}
