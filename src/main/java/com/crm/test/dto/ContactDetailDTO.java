package com.crm.test.dto;

public record ContactDetailDTO(Integer id,
                               String firstName,
                               String lastName,
                               String nickname,
                               String gender,
                               Boolean isActive,
                               CompanySimpleDTO company) {
}
