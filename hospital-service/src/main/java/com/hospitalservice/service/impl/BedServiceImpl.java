package com.hospitalservice.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hospitalservice.dto.BedRequestDTO;
import com.hospitalservice.dto.BedResponseDTO;
import com.hospitalservice.entity.Bed;
import com.hospitalservice.enums.BedStatus;
import com.hospitalservice.exception.NotFoundException;
import com.hospitalservice.repository.BedRepository;
import com.hospitalservice.service.BedService;

@Service
public class BedServiceImpl implements BedService {

    private final BedRepository repository;

    public BedServiceImpl(BedRepository repository) {
        this.repository = repository;
    }

    @Override
    public BedResponseDTO createBed(BedRequestDTO dto) {
        Bed bed = new Bed();
        bed.setHospitalId(dto.getHospitalId());
        bed.setBedType(dto.getBedType());
        bed.setStatus(dto.getStatus());

        Bed saved = repository.save(bed);
        return mapToResponse(saved);
    }

    @Override
    public BedResponseDTO getBedById(UUID bedId) {
        Bed bed = repository.findById(bedId)
                .orElseThrow(() -> new NotFoundException(
                        "Bed with ID " + bedId + " not found"));
        return mapToResponse(bed);
    }

    @Override
    public List<BedResponseDTO> getBedsByHospital(UUID hospitalId) {
        List<Bed> beds = repository.findByHospitalId(hospitalId);
        if (beds.isEmpty()) {
            throw new NotFoundException(
                    "No beds found for Hospital ID " + hospitalId);
        }
        return beds.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public List<BedResponseDTO> getAvailableBeds(UUID hospitalId) {
        List<Bed> beds = repository.findByHospitalIdAndStatus(hospitalId, BedStatus.VACANT);
        if (beds.isEmpty()) {
            throw new NotFoundException(
                    "No available beds found for Hospital ID " + hospitalId);
        }
        return beds.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private BedResponseDTO mapToResponse(Bed bed) {
        BedResponseDTO response = new BedResponseDTO();
        response.setBedId(bed.getBedId());
        response.setHospitalId(bed.getHospitalId());
        response.setBedType(bed.getBedType());
        response.setStatus(bed.getStatus());
        return response;
    }
}
