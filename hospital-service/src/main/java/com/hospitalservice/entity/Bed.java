package com.hospitalservice.entity;

import java.util.UUID;
import java.time.LocalDateTime;

import com.hospitalservice.enums.BedStatus;
import com.hospitalservice.enums.BedType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "beds")
@Getter
@Setter
public class Bed {

    @Id
    @GeneratedValue
    private UUID bedId;

    @Column(nullable = false)
    private UUID hospitalId; // link to Hospital

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BedType bedType; // ICU / GENERAL

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BedStatus status; // VACANT / OCCUPIED
    
    @Column(updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private LocalDateTime createdAt; // Automatically sets date when created

    @org.hibernate.annotations.UpdateTimestamp
    private LocalDateTime updatedAt; // Automatically updates date when status changes
}
