package com.squad.customermanagement.repository;

import com.squad.customermanagement.repository.entity.CustomerEntity;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class CustomerGroupSequenceProvider implements DefaultGroupSequenceProvider<CustomerEntity> {
    @Override
    public List<Class<?>> getValidationGroups(CustomerEntity customer) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(CustomerEntity.class);

        if(customer != null && customer.getType() != null) {
            groups.add(customer.getType().getValidationGroup());
        }

        return groups;
    }
}
