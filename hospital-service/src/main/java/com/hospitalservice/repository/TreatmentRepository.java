package com.hospitalservice.repository;

import com.hospitalservice.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TreatmentRepository extends JpaRepository<Treatment, UUID> {
    List<Treatment> findByDepartmentId(UUID departmentId);
}
