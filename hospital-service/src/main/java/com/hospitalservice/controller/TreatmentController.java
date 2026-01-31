package com.hospitalservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.hospitalservice.dto.TreatmentRequestDTO;
import com.hospitalservice.dto.TreatmentResponseDTO;
import com.hospitalservice.dto.TreatmentOutcomeDTO;
import com.hospitalservice.service.TreatmentService;

@RestController
@RequestMapping("/treatments")
public class TreatmentController {

    private final TreatmentService service;

    public TreatmentController(TreatmentService service) {
        this.service = service;
    }

    @PostMapping
    public TreatmentResponseDTO createTreatment(@RequestBody TreatmentRequestDTO dto) {
        return service.createTreatment(dto);
    }

    @GetMapping("/{id}")
    public TreatmentResponseDTO getTreatment(@PathVariable UUID id) {
        return service.getTreatmentById(id);
    }

    @GetMapping("/department/{deptId}")
    public List<TreatmentResponseDTO> getByDepartment(@PathVariable UUID deptId) {
        return service.getTreatmentsByDepartment(deptId);
    }

    @PostMapping("/record-outcome")
    public void recordOutcome(@RequestBody TreatmentOutcomeDTO dto) {
        service.recordTreatmentOutcome(dto.getTreatmentId(), dto.isSuccess());
    }

    @GetMapping("/{id}/success-rate")
    public double getSuccessRate(@PathVariable UUID id) {
        return service.calculateSuccessRate(id);
    }
}
