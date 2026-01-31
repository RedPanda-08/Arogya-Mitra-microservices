package com.hospitalservice.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreatmentRequestDTO {

    private String name;
    private Double cost;
    private Double successRate;
    private String proceduralExplanation;
    private UUID departmentId; // optional
}
