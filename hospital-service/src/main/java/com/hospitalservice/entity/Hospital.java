package com.hospitalservice.entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hospitals")
@Getter
@Setter

public class Hospital {
	@Id
	@GeneratedValue
	private UUID hospitalId;
	
	@Column(nullable = false)
	private String name;
	
	@Embedded 
	private Address address;
	
	private LocalDate establishedDate;
	
	@Column(length = 1000)
	private String achievements;
	
	private String contactNumber;
	
	private Integer totalBeds;

	@Column(updatable = false)
	@org.hibernate.annotations.CreationTimestamp
	private LocalDateTime createdAt; // Automatically sets date when created

	@org.hibernate.annotations.UpdateTimestamp
	private LocalDateTime updatedAt; // Automatically updates date when status changes
	
	
}
