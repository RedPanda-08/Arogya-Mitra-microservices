package com.hospitalservice.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.hospitalservice.enums.Outcome;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "treatment_records")

public class TreatmentRecord {

    @Id
    @GeneratedValue
    private UUID recordId;

    @Column(nullable = false)
    private UUID treatmentId; // FK to Treatment

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Outcome outcome; // SUCCESS or FAILURE

    private LocalDateTime performedAt = LocalDateTime.now();
}
