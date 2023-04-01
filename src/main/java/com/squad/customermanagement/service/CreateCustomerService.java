package com.squad.customermanagement.service;

import com.squad.customermanagement.service.domain.Customer;

import java.util.List;

public interface CreateCustomerService {
    Customer create(Customer customer);

    List<Customer> getAll();

    Customer getById(Long id);

    Customer update(Long id, Customer customer);

    Customer delete(Long id);
}
