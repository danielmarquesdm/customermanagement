package com.squad.customermanagement.service.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class CustomerRequestParams {
    private String name;
    private Status situation;
    private LocalDate registerDate;
    private Type type;
}
