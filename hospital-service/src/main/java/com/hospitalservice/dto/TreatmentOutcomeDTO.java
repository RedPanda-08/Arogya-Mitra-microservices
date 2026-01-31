package com.hospitalservice.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreatmentOutcomeDTO {
    private UUID treatmentId;
    private boolean success;
}
