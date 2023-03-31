package com.squad.customermanagement.controller.mapper;

import com.squad.customermanagement.controller.dto.CustomerRequestDTO;
import com.squad.customermanagement.controller.dto.CustomerResponseDTO;
import com.squad.customermanagement.service.domain.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer toDomain(CustomerRequestDTO request);

    CustomerResponseDTO toDTO(Customer customer);
}
