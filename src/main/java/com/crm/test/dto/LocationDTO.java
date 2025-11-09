package com.crm.test.dto;

import jakarta.validation.constraints.NotBlank;

public record LocationDTO (
        @NotBlank(message = "First address is required")
        String first_address,

        @NotBlank(message = "Second address is required")
        String second_address,

        @NotBlank(message = "City is required")
        String city,

        @NotBlank(message = "Province is required")
        String province,

        @NotBlank(message = "Country is required")
        String country) {
}
