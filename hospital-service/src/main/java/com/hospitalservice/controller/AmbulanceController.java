package com.hospitalservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalservice.dto.AmbulanceRequestDTO;
import com.hospitalservice.dto.AmbulanceResponseDTO;
import com.hospitalservice.service.AmbulanceService;

@RestController
@RequestMapping("/api/ambulances")
public class AmbulanceController {

    private final AmbulanceService service;

    public AmbulanceController(AmbulanceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AmbulanceResponseDTO> createAmbulance(@RequestBody AmbulanceRequestDTO dto) {
        return ResponseEntity.ok(service.createAmbulance(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmbulanceResponseDTO> getAmbulance(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getAmbulanceById(id));
    }

    @GetMapping("/hospital/{hospitalId}")
    public ResponseEntity<List<AmbulanceResponseDTO>> getByHospital(@PathVariable UUID hospitalId) {
        return ResponseEntity.ok(service.getAmbulancesByHospital(hospitalId));
    }

    @GetMapping("/hospital/{hospitalId}/available")
    public ResponseEntity<List<AmbulanceResponseDTO>> getAvailable(@PathVariable UUID hospitalId) {
        return ResponseEntity.ok(service.getAvailableAmbulances(hospitalId));
    }
}
