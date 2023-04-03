package com.squad.customermanagement.repository.mapper;

import com.squad.customermanagement.repository.entity.CustomerEntity;
import com.squad.customermanagement.repository.entity.PhoneNumberEntity;
import com.squad.customermanagement.service.domain.Customer;
import com.squad.customermanagement.service.domain.PhoneNumber;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerEntity toEntity(Customer customer);

    PhoneNumberEntity toEntity(PhoneNumber phoneNumber);

    Customer toDomain(CustomerEntity customer);

    PhoneNumber toDomain(PhoneNumberEntity phoneNumber);
}
