package com.crm.test.dto;

import com.crm.test.enums.Structure;

import java.util.List;

public record CompanyDetailDTO (
        Integer id,
        String employerIdentificationNumber,
        String name,
        Structure structure,
        String email,
        String phoneNumber,
        Boolean isActive,
        List<LocationDTO> locations,
        List<ContactDTO> contacts
) {
}
