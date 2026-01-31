package com.hospitalservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue
    private UUID departmentId;

    @Column(nullable = false)
    private String deptName;

    @Column(nullable = false)
    private UUID hospitalId; // Reference to Hospital

    @ElementCollection
    private List<UUID> treatmentsOffered; // store treatment IDs
}
