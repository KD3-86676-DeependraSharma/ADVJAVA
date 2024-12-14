package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="players")

@NoArgsConstructor
@Getter
@Setter
@ToString

public class Player extends BaseEntity{
	@Column(length=50,name="first_Name")
	private String first_name;
	@Column(length=20,name="last_name")  //you can write 20 in name which should be write last name in name.
	private String last_name;
	
	private LocalDate dob;
	@Column(name = "battingAvg")
	private double battingAvg;
    private int wicketTaken;
	//BlogPost *--->1 Category
	
    @ManyToOne()
    @JoinColumn(name ="team_id")
    private Team team;



}
