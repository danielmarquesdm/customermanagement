package com.squad.customermanagement.controller.builder;

import com.squad.customermanagement.controller.dto.StatusDTO;
import com.squad.customermanagement.controller.dto.TypeDTO;
import com.squad.customermanagement.controller.dto.response.CustomerResponse;

import java.time.LocalDate;
import java.util.List;

public class CustomerResponseBuilder {
    public static CustomerResponse build() {
        return CustomerResponse.builder()
                .id(1L)
                .name("Felipe")
                .federalId("828.536.920-00")
                .type(TypeDTO.NATURAL_PERSON)
                .rg("03206541354-56")
                .phoneNumbers(List.of(PhoneNumberDTOBuilder.buildResponse()))
                .registerDate(LocalDate.of(2023, 04, 01))
                .situation(StatusDTO.ACTIVE)
                .build();
    }
}
