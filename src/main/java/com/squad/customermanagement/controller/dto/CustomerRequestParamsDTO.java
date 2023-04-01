package com.squad.customermanagement.controller.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerRequestParamsDTO {
    private String name;
    private StatusDTO situation;
    private LocalDate registerDate;
    private TypeDTO type;
}
