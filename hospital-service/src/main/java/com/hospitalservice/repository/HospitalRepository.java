package com.hospitalservice.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalservice.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, UUID> {

}
