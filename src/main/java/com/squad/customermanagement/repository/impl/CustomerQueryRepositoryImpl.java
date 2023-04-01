package com.squad.customermanagement.repository.impl;

import com.squad.customermanagement.repository.CustomerQueryRepository;
import com.squad.customermanagement.repository.entity.CustomerEntity;
import com.squad.customermanagement.repository.entity.CustomerRequestParamsEntity;

import java.util.List;

public class CustomerQueryRepositoryImpl implements CustomerQueryRepository {
    @Override
    public List<CustomerEntity> findAllWithParameters(CustomerRequestParamsEntity customerRequestParamsEntity) {
        return null;
    }
}
