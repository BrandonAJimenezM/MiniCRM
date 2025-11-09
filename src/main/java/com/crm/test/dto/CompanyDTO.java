package com.crm.test.dto;

import com.crm.test.enums.Structure;
import com.crm.test.model.CompanyLocation;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CompanyDTO(

        @NotBlank(message = "Employer Identification Number is required")
        String employerIdentificationNumber,

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Structure is required")
        Structure structure,

        @NotBlank(message = "Invalid email")
        String email,

        @NotBlank(message = "Number is required")
        String phoneNumber,

        @NotBlank(message = "isActive must be true o false")
        Boolean isActive,

        @Valid
        LocationDTO location
) {}
