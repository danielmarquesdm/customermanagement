package com.squad.customermanagement.controller.dto.response;

import lombok.Data;

@Data
public class PhoneNumberResponseDTO {
    private Long id;
    private boolean mainPhoneNumber;
    private String phoneNumber;
}
