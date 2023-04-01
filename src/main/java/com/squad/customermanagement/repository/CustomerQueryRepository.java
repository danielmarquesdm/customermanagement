package com.squad.customermanagement.repository;

import com.squad.customermanagement.repository.entity.CustomerEntity;
import com.squad.customermanagement.repository.entity.CustomerRequestParamsEntity;

import java.util.List;

public interface CustomerQueryRepository {
    List<CustomerEntity> findAllWithParameters(CustomerRequestParamsEntity customerRequestParamsEntity);
}
