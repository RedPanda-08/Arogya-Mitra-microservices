package com.hospitalservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalservice.entity.Ambulance;

public interface AmbulanceRepository extends JpaRepository<Ambulance, UUID> {

    List<Ambulance> findByHospitalId(UUID hospitalId);

    List<Ambulance> findByHospitalIdAndAvailable(UUID hospitalId, Boolean available);
}
