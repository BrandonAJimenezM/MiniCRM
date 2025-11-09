package com.crm.test.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContactRequestDTO(

        @NotNull(message = "Company ID is required")
        Integer idCompany,

        @NotBlank(message = "First name is required")
        String firstName,

        @NotBlank(message = "MiddleName is required")
        String middleName,

        @NotBlank(message = "Last name is required")
        String lastName,

        String mothersName,

        String nickname,

        @NotNull(message = "Birthday name is required")
        String birthday,

        @NotBlank(message = "Gender is required")
        String gender,

        @NotNull(message = "isActive must be true or false")
        Boolean isActive
) {
}
