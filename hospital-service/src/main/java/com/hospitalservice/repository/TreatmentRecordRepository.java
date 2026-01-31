package com.hospitalservice.repository;

import com.hospitalservice.entity.TreatmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TreatmentRecordRepository extends JpaRepository<TreatmentRecord, UUID> {
    List<TreatmentRecord> findByTreatmentId(UUID treatmentId);
}
