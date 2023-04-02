package com.squad.customermanagement.service.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerRequestParams {
    private String name;
    private Status situation;
    private LocalDate registerDate;
    private Type type;
}
