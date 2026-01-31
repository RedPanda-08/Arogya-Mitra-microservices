package com.hospitalservice.controller;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalservice.dto.HospitalResponseDTO;
import com.hospitalservice.service.HospitalService;

@RestController
@RequestMapping("/api/hospitals")

public class HospitalController {
	private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponseDTO> getHospital(
            @PathVariable UUID id) {
        return ResponseEntity.ok(hospitalService.getHospitalById(id));
    }

}
