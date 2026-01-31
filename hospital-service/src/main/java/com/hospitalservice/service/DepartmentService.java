package com.hospitalservice.service;

import java.util.List;
import java.util.UUID;

import com.hospitalservice.dto.DepartmentRequestDTO;
import com.hospitalservice.dto.DepartmentResponseDTO;

public interface DepartmentService {

    DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto);

    DepartmentResponseDTO getDepartmentById(UUID departmentId);

    List<DepartmentResponseDTO> getDepartmentsByHospital(UUID hospitalId);
}
