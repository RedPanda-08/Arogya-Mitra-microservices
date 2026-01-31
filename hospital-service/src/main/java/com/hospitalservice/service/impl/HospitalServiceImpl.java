package com.hospitalservice.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hospitalservice.dto.AddressDTO;
import com.hospitalservice.dto.HospitalRequestDTO;
import com.hospitalservice.dto.HospitalResponseDTO;
import com.hospitalservice.entity.Address;
import com.hospitalservice.entity.Hospital;
import com.hospitalservice.exception.NotFoundException;
import com.hospitalservice.repository.HospitalRepository;
import com.hospitalservice.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalServiceImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public HospitalResponseDTO createHospital(HospitalRequestDTO dto) {

        // Convert AddressDTO to Address entity
        Address address = new Address();
        AddressDTO addressDTO = dto.getAddress();
        if (addressDTO != null) {
            address.setState(addressDTO.getState());
            address.setCity(addressDTO.getCity());
            address.setArea(addressDTO.getArea());
            address.setPincode(addressDTO.getPincode());
            address.setAddressLine(addressDTO.getAddressLine());
        }

        // Create Hospital entity
        Hospital hospital = new Hospital();
        hospital.setName(dto.getName());
        hospital.setAddress(address);
        hospital.setEstablishedDate(dto.getEstablishedDate());
        hospital.setAchievements(dto.getAchievements());
        hospital.setContactNumber(dto.getContactNumber());
        hospital.setTotalBeds(dto.getTotalBeds());
        hospital.setCreatedAt(LocalDateTime.now());

        // Save to DB
        Hospital savedHospital = hospitalRepository.save(hospital);

        // Build response DTO
        HospitalResponseDTO response = new HospitalResponseDTO();
        response.setHospitalId(savedHospital.getHospitalId());
        response.setName(savedHospital.getName());
        if (savedHospital.getAddress() != null) {
            response.setCity(savedHospital.getAddress().getCity());
        }
        response.setTotalBeds(savedHospital.getTotalBeds());

        return response;
    }

    @Override
    public HospitalResponseDTO getHospitalById(UUID hospitalId) {

        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new NotFoundException(
                        "Hospital with ID " + hospitalId + " not found"));

        HospitalResponseDTO response = new HospitalResponseDTO();
        response.setHospitalId(hospital.getHospitalId());
        response.setName(hospital.getName());
        if (hospital.getAddress() != null) {
            response.setCity(hospital.getAddress().getCity());
        }
        response.setTotalBeds(hospital.getTotalBeds());

        return response;
    }
}
