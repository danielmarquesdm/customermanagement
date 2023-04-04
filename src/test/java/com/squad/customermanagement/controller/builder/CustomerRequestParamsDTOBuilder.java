package com.squad.customermanagement.controller.builder;

import com.squad.customermanagement.controller.dto.StatusDTO;
import com.squad.customermanagement.controller.dto.TypeDTO;
import com.squad.customermanagement.controller.dto.request.CustomerRequestParamsDTO;

import java.time.LocalDate;

public class CustomerRequestParamsDTOBuilder {
    public static CustomerRequestParamsDTO build() {
        return CustomerRequestParamsDTO.builder()
                .name("Felipe")
                .type(TypeDTO.NATURAL_PERSON)
                .registerDate(LocalDate.of(2023, 04, 01))
                .situation(StatusDTO.ACTIVE)
                .build();
    }
}
