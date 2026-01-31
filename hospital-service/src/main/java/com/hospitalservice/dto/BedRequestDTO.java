package com.hospitalservice.dto;

import java.util.UUID;

import com.hospitalservice.enums.BedStatus;
import com.hospitalservice.enums.BedType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BedRequestDTO {

    private UUID hospitalId;
    private BedType bedType;
    private BedStatus status;
}
