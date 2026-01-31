package com.hospitalservice.service;

import com.hospitalservice.dto.TreatmentRequestDTO;
import com.hospitalservice.dto.TreatmentResponseDTO;
import java.util.List;
import java.util.UUID;

public interface TreatmentService {

    TreatmentResponseDTO createTreatment(TreatmentRequestDTO dto);

    TreatmentResponseDTO getTreatmentById(UUID treatmentId);

    List<TreatmentResponseDTO> getTreatmentsByDepartment(UUID departmentId);

    void recordTreatmentOutcome(UUID treatmentId, boolean success);

    double calculateSuccessRate(UUID treatmentId);
}
