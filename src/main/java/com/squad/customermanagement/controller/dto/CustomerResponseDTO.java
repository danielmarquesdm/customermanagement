package com.squad.customermanagement.controller.dto;

import java.time.LocalDate;
import java.util.List;

public class CustomerResponseDTO {
    private Long Id;
    private String name;
    private TypeDTO type;
    private String federalId;
    private String rg;
    private String ie;
    private LocalDate registerDate;
    private StatusDTO situation;
    private List<String> phoneNumbers;
}
