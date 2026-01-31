package com.hospitalservice.service;

import java.util.List;
import java.util.UUID;

import com.hospitalservice.dto.BedRequestDTO;
import com.hospitalservice.dto.BedResponseDTO;

public interface BedService {

    BedResponseDTO createBed(BedRequestDTO dto);

    BedResponseDTO getBedById(UUID bedId);

    List<BedResponseDTO> getBedsByHospital(UUID hospitalId);

    List<BedResponseDTO> getAvailableBeds(UUID hospitalId);
}
