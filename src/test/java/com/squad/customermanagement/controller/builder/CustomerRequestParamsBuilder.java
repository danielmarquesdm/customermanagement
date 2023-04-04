package com.squad.customermanagement.controller.builder;

import com.squad.customermanagement.service.domain.CustomerRequestParams;
import com.squad.customermanagement.service.domain.Status;
import com.squad.customermanagement.service.domain.Type;

import java.time.LocalDate;

public class CustomerRequestParamsBuilder {
    public static CustomerRequestParams build() {
        return CustomerRequestParams.builder()
                .name("Felipe")
                .type(Type.NATURAL_PERSON)
                .registerDate(LocalDate.of(2023, 04, 01))
                .situation(Status.ACTIVE)
                .build();
    }
}
