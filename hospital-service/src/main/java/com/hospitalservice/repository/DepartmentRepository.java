package com.hospitalservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, UUID> {
    List<Department> findByHospitalId(UUID hospitalId);
}
