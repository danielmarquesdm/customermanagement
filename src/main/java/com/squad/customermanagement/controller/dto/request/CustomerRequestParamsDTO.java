package com.squad.customermanagement.controller.dto.request;

import com.squad.customermanagement.controller.dto.StatusDTO;
import com.squad.customermanagement.controller.dto.TypeDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerRequestParamsDTO {
    private String name;
    private StatusDTO situation;
    private LocalDate registerDate;
    private TypeDTO type;
}
