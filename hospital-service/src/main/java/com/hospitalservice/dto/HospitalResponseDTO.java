package com.hospitalservice.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospitalResponseDTO {
    private UUID hospitalId;      // private
    private String name;
    private String city;
    private Integer totalBeds;
}
