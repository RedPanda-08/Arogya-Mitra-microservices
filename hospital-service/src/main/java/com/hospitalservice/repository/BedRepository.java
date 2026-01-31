package com.hospitalservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalservice.entity.Bed;
import com.hospitalservice.enums.BedStatus;

public interface BedRepository extends JpaRepository<Bed, UUID> {

    List<Bed> findByHospitalId(UUID hospitalId);

    List<Bed> findByHospitalIdAndStatus(UUID hospitalId, BedStatus status);
}
