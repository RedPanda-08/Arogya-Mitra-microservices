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

import com.hospitalservice.dto.DepartmentRequestDTO;
import com.hospitalservice.dto.DepartmentResponseDTO;
import com.hospitalservice.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> createDepartment(@RequestBody DepartmentRequestDTO dto) {
        return ResponseEntity.ok(service.createDepartment(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> getDepartment(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getDepartmentById(id));
    }

    @GetMapping("/hospital/{hospitalId}")
    public ResponseEntity<List<DepartmentResponseDTO>> getByHospital(@PathVariable UUID hospitalId) {
        return ResponseEntity.ok(service.getDepartmentsByHospital(hospitalId));
    }
}
