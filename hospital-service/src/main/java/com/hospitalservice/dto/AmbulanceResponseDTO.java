package com.hospitalservice.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmbulanceResponseDTO {

    private UUID ambulanceId;
    private String vehicleNumber;
    private String driverName;
    private String location;
    private Boolean available;
    private UUID hospitalId;
}
