package com.blogs.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class AadharCard {
	@Column(name = "card_number", length = 20, unique = true)
	private String cardNumber;
	@Column(name = "card_created_on")
	private LocalDate createdOn;
	@Column(length = 30)
	private String location;
	
	
	public AadharCard(String cardNumber, String location) {
		super();
		this.cardNumber = cardNumber;
		this.location = location;
	}	
	
}
