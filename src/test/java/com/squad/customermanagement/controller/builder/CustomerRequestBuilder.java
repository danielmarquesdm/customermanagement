package com.squad.customermanagement.controller.builder;

import com.squad.customermanagement.controller.dto.TypeDTO;
import com.squad.customermanagement.controller.dto.request.CustomerRequest;

import java.util.List;

public class CustomerRequestBuilder {
    public static CustomerRequest build() {
        return CustomerRequest.builder()
                .name("Felipe")
                .federalId("828.536.920-00")
                .type(TypeDTO.NATURAL_PERSON)
                .rg("03206541354-56")
                .phoneNumbers(List.of(PhoneNumberDTOBuilder.buildRequest()))
                .build();
    }
}
