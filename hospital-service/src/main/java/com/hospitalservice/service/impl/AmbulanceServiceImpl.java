package com.hospitalservice.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hospitalservice.dto.AmbulanceRequestDTO;
import com.hospitalservice.dto.AmbulanceResponseDTO;
import com.hospitalservice.entity.Ambulance;
import com.hospitalservice.exception.NotFoundException;
import com.hospitalservice.repository.AmbulanceRepository;
import com.hospitalservice.service.AmbulanceService;

@Service
public class AmbulanceServiceImpl implements AmbulanceService {

    private final AmbulanceRepository repository;

    public AmbulanceServiceImpl(AmbulanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public AmbulanceResponseDTO createAmbulance(AmbulanceRequestDTO dto) {
        Ambulance ambulance = new Ambulance();
        ambulance.setVehicleNumber(dto.getVehicleNumber());
        ambulance.setDriverName(dto.getDriverName());
        ambulance.setLocation(dto.getLocation());
        ambulance.setAvailable(dto.getAvailable());
        ambulance.setHospitalId(dto.getHospitalId());

        Ambulance saved = repository.save(ambulance);
        return mapToResponse(saved);
    }

    @Override
    public AmbulanceResponseDTO getAmbulanceById(UUID ambulanceId) {
        Ambulance ambulance = repository.findById(ambulanceId)
                .orElseThrow(() -> new NotFoundException(
                        "Ambulance with ID " + ambulanceId + " not found"));
        return mapToResponse(ambulance);
    }

    @Override
    public List<AmbulanceResponseDTO> getAmbulancesByHospital(UUID hospitalId) {
        List<Ambulance> list = repository.findByHospitalId(hospitalId);
        if (list.isEmpty()) {
            throw new NotFoundException(
                    "No ambulances found for Hospital ID " + hospitalId);
        }
        return list.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public List<AmbulanceResponseDTO> getAvailableAmbulances(UUID hospitalId) {
        List<Ambulance> list = repository.findByHospitalIdAndAvailable(hospitalId, true);
        if (list.isEmpty()) {
            throw new NotFoundException(
                    "No available ambulances found for Hospital ID " + hospitalId);
        }
        return list.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private AmbulanceResponseDTO mapToResponse(Ambulance ambulance) {
        AmbulanceResponseDTO response = new AmbulanceResponseDTO();
        response.setAmbulanceId(ambulance.getAmbulanceId());
        response.setVehicleNumber(ambulance.getVehicleNumber());
        response.setDriverName(ambulance.getDriverName());
        response.setLocation(ambulance.getLocation());
        response.setAvailable(ambulance.getAvailable());
        response.setHospitalId(ambulance.getHospitalId());
        return response;
    }
}
