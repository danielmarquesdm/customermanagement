package com.squad.customermanagement.service.impl;

import com.squad.customermanagement.service.domain.Customer;
import com.squad.customermanagement.repository.CustomerRepository;
import com.squad.customermanagement.service.CreateCustomerService;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerServiceImpl implements CreateCustomerService {
    private CustomerRepository repository;

    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }
}
