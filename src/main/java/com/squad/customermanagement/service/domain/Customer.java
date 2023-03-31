package com.squad.customermanagement.service.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Customer {
    private Long Id;
    private String name;
    private Type type;
    private String federalId;
    private String rg;
    private String ie;
    private LocalDate registerDate;
    private Status situation;
    private List<String> phoneNumbers;
}
