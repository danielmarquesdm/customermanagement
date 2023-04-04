package com.squad.customermanagement.controller.builder;

import com.squad.customermanagement.controller.dto.request.PhoneNumberRequestDTO;
import com.squad.customermanagement.controller.dto.response.PhoneNumberResponseDTO;

public class PhoneNumberDTOBuilder {
    public static PhoneNumberRequestDTO buildRequest() {
        return PhoneNumberRequestDTO.builder()
                .id(1L)
                .mainPhoneNumber(true)
                .phoneNumber("896958236")
                .build();
    }

    public static PhoneNumberResponseDTO buildResponse() {
        return PhoneNumberResponseDTO.builder()
                .id(1L)
                .mainPhoneNumber(true)
                .phoneNumber("896958236")
                .build();
    }
}
