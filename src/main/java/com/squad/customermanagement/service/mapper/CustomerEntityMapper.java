package com.squad.customermanagement.service.mapper;

import com.squad.customermanagement.repository.entity.CustomerEntity;
import com.squad.customermanagement.service.domain.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerEntityMapper {
    CustomerEntity toEntity(Customer customer);

    Customer toDomain(CustomerEntity customer);
}
