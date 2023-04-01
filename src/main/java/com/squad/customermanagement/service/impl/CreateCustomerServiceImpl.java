package com.squad.customermanagement.service.impl;

import com.squad.customermanagement.repository.CustomerRepository;
import com.squad.customermanagement.repository.entity.CustomerEntity;
import com.squad.customermanagement.repository.entity.CustomerRequestParamsEntity;
import com.squad.customermanagement.repository.mapper.CustomerEntityMapper;
import com.squad.customermanagement.service.CreateCustomerService;
import com.squad.customermanagement.service.domain.Customer;
import com.squad.customermanagement.service.domain.CustomerRequestParams;
import com.squad.customermanagement.service.domain.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CreateCustomerServiceImpl implements CreateCustomerService {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerEntityMapper mapper;

    @Override
    public Customer create(Customer customer) {
        CustomerEntity customerEntity = mapper.toEntity(customer.toBuilder()
                .registerDate(LocalDate.now())
                .situation(Status.ACTIVE)
                .build());

        CustomerEntity savedCustomer = repository.save(customerEntity);
        return mapper.toDomain(savedCustomer);
    }

    @Override
    public List<Customer> getAll(CustomerRequestParams params) {
        CustomerRequestParamsEntity customerRequestParamsEntity = mapper.toEntity(params);
        return repository.findAllWithParameters(customerRequestParamsEntity)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public Customer getById(Long id) {
        Optional<CustomerEntity> customerOptional = repository.findById(id);

        CustomerEntity customerEntity = customerOptional.orElseThrow(RuntimeException::new);

        return mapper.toDomain(customerEntity);
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Customer byId = this.getById(id);

        CustomerEntity saved = repository.save(mapper
                .toEntity(customer.toBuilder().id(id).build()));

        return mapper.toDomain(saved);
    }

    @Override
    public Customer delete(Long id) {
        Customer byId = this.getById(id);
        CustomerEntity saved = repository.save(mapper
                .toEntity(byId.toBuilder().situation(Status.INACTIVE).build()));
        return mapper.toDomain(saved);
    }
}
