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

import com.hospitalservice.dto.BedRequestDTO;
import com.hospitalservice.dto.BedResponseDTO;
import com.hospitalservice.service.BedService;

@RestController
@RequestMapping("/api/beds")
public class BedController {

    private final BedService service;

    public BedController(BedService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BedResponseDTO> createBed(@RequestBody BedRequestDTO dto) {
        return ResponseEntity.ok(service.createBed(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BedResponseDTO> getBed(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getBedById(id));
    }

    @GetMapping("/hospital/{hospitalId}")
    public ResponseEntity<List<BedResponseDTO>> getBedsByHospital(@PathVariable UUID hospitalId) {
        return ResponseEntity.ok(service.getBedsByHospital(hospitalId));
    }

    @GetMapping("/hospital/{hospitalId}/available")
    public ResponseEntity<List<BedResponseDTO>> getAvailableBeds(@PathVariable UUID hospitalId) {
        return ResponseEntity.ok(service.getAvailableBeds(hospitalId));
    }
}
