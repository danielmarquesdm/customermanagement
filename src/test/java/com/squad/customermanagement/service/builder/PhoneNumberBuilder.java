package com.squad.customermanagement.service.builder;

import com.squad.customermanagement.service.domain.PhoneNumber;

public class PhoneNumberBuilder {
    public static PhoneNumber build() {
        return PhoneNumber.builder()
                .id(1L)
                .mainPhoneNumber(true)
                .phoneNumber("896958236")
                .build();
    }
}
