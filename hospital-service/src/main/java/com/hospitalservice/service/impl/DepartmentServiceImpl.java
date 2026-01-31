package com.hospitalservice.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hospitalservice.dto.DepartmentRequestDTO;
import com.hospitalservice.dto.DepartmentResponseDTO;
import com.hospitalservice.entity.Department;
import com.hospitalservice.exception.NotFoundException;
import com.hospitalservice.repository.DepartmentRepository;
import com.hospitalservice.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto) {
        Department dept = new Department();
        dept.setDeptName(dto.getDeptName());
        dept.setHospitalId(dto.getHospitalId());
        dept.setTreatmentsOffered(dto.getTreatmentsOffered());

        Department saved = repository.save(dept);
        return mapToResponse(saved);
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(UUID departmentId) {
        Department dept = repository.findById(departmentId)
                .orElseThrow(() -> new NotFoundException(
                        "Department with ID " + departmentId + " not found"));
        return mapToResponse(dept);
    }

    @Override
    public List<DepartmentResponseDTO> getDepartmentsByHospital(UUID hospitalId) {
        List<Department> list = repository.findByHospitalId(hospitalId);
        if (list.isEmpty()) {
            throw new NotFoundException(
                    "No departments found for Hospital ID " + hospitalId);
        }
        return list.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private DepartmentResponseDTO mapToResponse(Department dept) {
        DepartmentResponseDTO response = new DepartmentResponseDTO();
        response.setDepartmentId(dept.getDepartmentId());
        response.setDeptName(dept.getDeptName());
        response.setHospitalId(dept.getHospitalId());
        response.setTreatmentsOffered(dept.getTreatmentsOffered());
        return response;
    }
}
