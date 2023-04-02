package com.squad.customermanagement.service;

import com.squad.customermanagement.service.domain.Customer;
import com.squad.customermanagement.service.domain.CustomerRequestParams;
import com.squad.customermanagement.service.domain.PhoneNumber;

import java.util.List;

public interface CreateCustomerService {
    Customer create(Customer customer);

    List<Customer> getAll(CustomerRequestParams params);

    Customer getById(Long id);

    Customer update(Long id, Customer customer);

    Customer delete(Long id);

    List<PhoneNumber> changePhoneNumbers(Long id, List<PhoneNumber> phoneNumbers);
}
