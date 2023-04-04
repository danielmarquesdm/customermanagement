package com.squad.customermanagement.controller.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneNumberResponseDTO {
    private Long id;
    private boolean mainPhoneNumber;
    private String phoneNumber;
}
