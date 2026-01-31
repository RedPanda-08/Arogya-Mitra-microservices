package com.hospitalservice.dto;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentResponseDTO {

    private UUID departmentId;
    private String deptName;
    private UUID hospitalId;
    private List<UUID> treatmentsOffered;
}
