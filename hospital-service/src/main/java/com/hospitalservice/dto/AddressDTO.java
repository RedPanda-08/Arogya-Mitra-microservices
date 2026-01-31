package com.hospitalservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private String state;
    private String city;
    private String area;
    private String pincode;
    private String addressLine;
}
