package com.squad.customermanagement.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private Long id;
    private String name;
    private TypeDTO type;
    private String federalId;
    private String rg;
    private String ie;
    private LocalDate registerDate;
    private StatusDTO situation;
    private List<PhoneNumberDTO> phoneNumbers;
}
