package com.squad.customermanagement.controller.mapper;

import com.squad.customermanagement.controller.dto.request.PhoneNumberRequestDTO;
import com.squad.customermanagement.controller.dto.request.CustomerRequest;
import com.squad.customermanagement.controller.dto.request.CustomerRequestParamsDTO;
import com.squad.customermanagement.controller.dto.response.CustomerResponse;
import com.squad.customermanagement.controller.dto.response.PhoneNumberResponseDTO;
import com.squad.customermanagement.service.domain.Customer;
import com.squad.customermanagement.service.domain.CustomerRequestParams;
import com.squad.customermanagement.service.domain.PhoneNumber;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toDomain(CustomerRequest request);

    CustomerRequestParams toDomain(CustomerRequestParamsDTO requestParams);

    PhoneNumber toDomain(PhoneNumberRequestDTO phoneNumber);

    CustomerResponse toResponse(Customer customer);

    PhoneNumberResponseDTO toResponse(PhoneNumber phoneNumber);
}
