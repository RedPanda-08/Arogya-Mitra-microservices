package com.hospitalservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "treatments")
@Getter
@Setter
public class Treatment {

    @Id
    @GeneratedValue
    private UUID treatmentId;

    @Column(nullable = false)
    private String name;

    private Double cost;
    private Double successRate;

    @Column(length = 2000)
    private String proceduralExplanation;

    private UUID departmentId; // optional link to department
}
