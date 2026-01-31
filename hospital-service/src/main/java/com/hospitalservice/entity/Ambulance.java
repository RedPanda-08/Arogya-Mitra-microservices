package com.hospitalservice.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ambulances")
@Getter
@Setter
public class Ambulance {

    @Id
    @GeneratedValue
    private UUID ambulanceId;

    @Column(nullable = false)
    private String vehicleNumber;

    private String driverName;

    private String location; // current location

    @Column(nullable = false)
    private Boolean available;

    private UUID hospitalId; // optional: link to hospital
}
