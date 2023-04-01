package com.squad.customermanagement.repository.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerRequestParamsEntity {
    private String name;
    private StatusEntity situation;
    private LocalDate registerDate;
    private TypeEntity type;
}
