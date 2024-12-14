package com.sunbeam.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id; // mapped to PK
	// creation date
	@CreationTimestamp
	@Column(name="created_on")
	private LocalDate createdOn;
	// updataion time stamp
	@UpdateTimestamp
	@Column(name="updated_on")
	private LocalDateTime updatedOn;
//	@Version //used for optimistic locking
//	private int entityVersion;
}
