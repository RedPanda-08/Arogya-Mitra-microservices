package com.hospitalservice.service;

import java.util.List;
import java.util.UUID;

import com.hospitalservice.dto.AmbulanceRequestDTO;
import com.hospitalservice.dto.AmbulanceResponseDTO;

public interface AmbulanceService {

    AmbulanceResponseDTO createAmbulance(AmbulanceRequestDTO dto);

    AmbulanceResponseDTO getAmbulanceById(UUID ambulanceId);

    List<AmbulanceResponseDTO> getAmbulancesByHospital(UUID hospitalId);

    List<AmbulanceResponseDTO> getAvailableAmbulances(UUID hospitalId);
}
