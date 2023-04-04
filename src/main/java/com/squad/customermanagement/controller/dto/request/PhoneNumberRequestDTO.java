package com.squad.customermanagement.controller.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class PhoneNumberRequestDTO {
    private Long id;
    private boolean mainPhoneNumber;
    private String phoneNumber;
}
