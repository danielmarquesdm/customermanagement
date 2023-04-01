package com.squad.customermanagement.controller.mapper;

import com.squad.customermanagement.controller.dto.CustomerRequest;
import com.squad.customermanagement.controller.dto.CustomerResponse;
import com.squad.customermanagement.service.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toDomain(CustomerRequest request);

    CustomerResponse toResponse(Customer customer);
}
