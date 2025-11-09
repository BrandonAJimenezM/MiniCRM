package com.crm.test.dto;

public record ContactDTO(

        Integer id,
        String firstName,
        String lastName,
        String nickname,
        String gender,
        Boolean isActive) {
}
