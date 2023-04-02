package com.squad.customermanagement.controller.dto.request;

import lombok.Data;

@Data
public class PhoneNumberRequestDTO {
    private Long id;
    private boolean mainPhoneNumber;
    private String phoneNumber;
}
