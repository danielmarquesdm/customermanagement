package com.squad.customermanagement.service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private Type type;
    private String federalId;
    private String rg;
    private String ie;
    private LocalDate registerDate;
    private Status situation;
    private String phoneNumber;
}
