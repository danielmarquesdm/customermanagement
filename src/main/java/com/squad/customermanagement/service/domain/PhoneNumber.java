package com.squad.customermanagement.service.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class PhoneNumber {
    private Long id;
    private boolean mainPhoneNumber;
    private String phoneNumber;
}
