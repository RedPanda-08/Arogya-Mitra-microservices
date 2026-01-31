package com.hospitalservice.service;
import java.util.UUID;

import  com.hospitalservice.dto.HospitalRequestDTO;
import com.hospitalservice.dto.HospitalResponseDTO;

public interface HospitalService {
	HospitalResponseDTO createHospital(HospitalRequestDTO dto);

    HospitalResponseDTO getHospitalById(UUID hospitalId);

}
