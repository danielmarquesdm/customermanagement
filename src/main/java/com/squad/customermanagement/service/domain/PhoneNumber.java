package com.squad.customermanagement.service.domain;

import lombok.Data;

@Data
public class PhoneNumber {
    private Long id;
    private boolean mainPhoneNumber;
    private String phoneNumber;
}
