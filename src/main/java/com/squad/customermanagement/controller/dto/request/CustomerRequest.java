package com.squad.customermanagement.controller.dto.request;

import com.squad.customermanagement.controller.dto.TypeDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    @NotBlank
    private String name;
    @NotNull
    private TypeDTO type;
    private String federalId;
    private String rg;
    private String ie;
    private List<PhoneNumberRequestDTO> phoneNumbers;
}
