package com.hospitalservice.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospitalRequestDTO {
    private String name;          // private
    private AddressDTO address;
    private LocalDate establishedDate;
    private String achievements;
    private String contactNumber;
    private Integer totalBeds;
}
