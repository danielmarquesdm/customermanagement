package com.squad.customermanagement.repository.entity;

import java.time.LocalDate;
import java.util.List;

public class CustomerEntity {
    private Long Id;
    private String name;
    private TypeEntity type;
    private String federalId;
    private String rg;
    private String ie;
    private LocalDate registerDate;
    private StatusEntity situation;
    private List<String> phoneNumbers;
}
