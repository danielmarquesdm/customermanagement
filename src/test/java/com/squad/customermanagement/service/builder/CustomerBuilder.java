package com.squad.customermanagement.service.builder;

import com.squad.customermanagement.service.domain.Customer;
import com.squad.customermanagement.service.domain.Type;

import java.util.List;

public class CustomerBuilder {
    public static Customer build() {
        return Customer.builder()
                .id(1L)
                .name("Felipe")
                .federalId("828.536.920-00")
                .type(Type.NATURAL_PERSON)
                .rg("03206541354-56")
                .phoneNumbers(List.of(PhoneNumberBuilder.build()))
                .build();
    }
}
