package com.hospitalservice.dto;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentRequestDTO {

    private String deptName;
    private UUID hospitalId;
    private List<UUID> treatmentsOffered; // optional
}
