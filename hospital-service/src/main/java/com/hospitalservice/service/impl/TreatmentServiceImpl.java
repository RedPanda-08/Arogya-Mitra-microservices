package com.hospitalservice.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hospitalservice.dto.TreatmentRequestDTO;
import com.hospitalservice.dto.TreatmentResponseDTO;
import com.hospitalservice.entity.Treatment;
import com.hospitalservice.entity.TreatmentRecord;
import com.hospitalservice.enums.Outcome;
import com.hospitalservice.exception.NotFoundException;
import com.hospitalservice.repository.TreatmentRecordRepository;
import com.hospitalservice.repository.TreatmentRepository;
import com.hospitalservice.service.TreatmentService;

@Service
public class TreatmentServiceImpl implements TreatmentService {

    private final TreatmentRepository treatmentRepository;
    private final TreatmentRecordRepository recordRepository;

    public TreatmentServiceImpl(TreatmentRepository treatmentRepository,
                                TreatmentRecordRepository recordRepository) {
        this.treatmentRepository = treatmentRepository;
        this.recordRepository = recordRepository;
    }

    @Override
    public TreatmentResponseDTO createTreatment(TreatmentRequestDTO dto) {
        Treatment treatment = new Treatment();
        treatment.setName(dto.getName());
        treatment.setCost(dto.getCost());
        treatment.setProceduralExplanation(dto.getProceduralExplanation());
        treatment.setDepartmentId(dto.getDepartmentId());

        Treatment saved = treatmentRepository.save(treatment);
        return mapToResponse(saved);
    }

    @Override
    public TreatmentResponseDTO getTreatmentById(UUID treatmentId) {
        Treatment treatment = treatmentRepository.findById(treatmentId)
                .orElseThrow(() ->
                        new NotFoundException("Treatment not found with id: " + treatmentId)
                );
        return mapToResponse(treatment);
    }

    @Override
    public List<TreatmentResponseDTO> getTreatmentsByDepartment(UUID departmentId) {
        List<Treatment> list = treatmentRepository.findByDepartmentId(departmentId);

        if (list.isEmpty()) {
            throw new NotFoundException(
                    "No treatments found for department id: " + departmentId
            );
        }

        return list.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void recordTreatmentOutcome(UUID treatmentId, boolean success) {

        // Ensure treatment exists
        Treatment treatment = treatmentRepository.findById(treatmentId)
                .orElseThrow(() ->
                        new NotFoundException("Cannot record outcome. Treatment not found: " + treatmentId)
                );

        TreatmentRecord record = new TreatmentRecord();
        record.setTreatmentId(treatment.getTreatmentId());
        record.setOutcome(success ? Outcome.SUCCESS : Outcome.FAILURE);

        recordRepository.save(record);
    }

    @Override
    public double calculateSuccessRate(UUID treatmentId) {

        // Validate treatment existence
        if (!treatmentRepository.existsById(treatmentId)) {
            throw new NotFoundException(
                    "Cannot calculate success rate. Treatment not found: " + treatmentId
            );
        }

        List<TreatmentRecord> records = recordRepository.findByTreatmentId(treatmentId);

        if (records.isEmpty()) {
            return 0.0; // No history yet (valid case)
        }

        long successCount = records.stream()
                .filter(r -> r.getOutcome() == Outcome.SUCCESS)
                .count();

        return (successCount * 100.0) / records.size();
    }

    private TreatmentResponseDTO mapToResponse(Treatment treatment) {
        TreatmentResponseDTO response = new TreatmentResponseDTO();
        response.setTreatmentId(treatment.getTreatmentId());
        response.setName(treatment.getName());
        response.setCost(treatment.getCost());
        response.setProceduralExplanation(treatment.getProceduralExplanation());
        response.setDepartmentId(treatment.getDepartmentId());
        response.setSuccessRate(calculateSuccessRate(treatment.getTreatmentId()));
        return response;
    }
}
