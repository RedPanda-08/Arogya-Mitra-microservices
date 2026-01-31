package com.hospitalservice.entity;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data

public class Address {
	private String state;
	private String city;
	private String area;
	private String pincode;
	private String addressLine;

}
