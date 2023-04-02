package com.squad.customermanagement.service.impl;

import com.squad.customermanagement.repository.CustomerRepository;
import com.squad.customermanagement.repository.entity.CustomerEntity;
import com.squad.customermanagement.repository.entity.StatusEntity;
import com.squad.customermanagement.repository.mapper.CustomerEntityMapper;
import com.squad.customermanagement.service.CreateCustomerService;
import com.squad.customermanagement.service.domain.Customer;
import com.squad.customermanagement.service.domain.PhoneNumber;
import com.squad.customermanagement.service.domain.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
        List<PhoneNumber> phoneNumbers = new ArrayList<>();

        if (!customer.getPhoneNumbers().isEmpty()) {
            List<PhoneNumber> validatedPhoneNumbers = validatePhoneNumbers(customer.getPhoneNumbers());
            phoneNumbers = sortPhoneNumbers(validatedPhoneNumbers);
        }

        CustomerEntity customerEntity = mapper.toEntity(customer.toBuilder()
                .registerDate(LocalDate.now())
                .situation(Status.ACTIVE)
                .phoneNumbers(phoneNumbers)
                .build());

        CustomerEntity savedCustomer = repository.save(customerEntity);

        return mapper.toDomain(savedCustomer);
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public Customer getById(Long id) {
        return this.getCustomer(id);
    }

    private Customer getCustomer(Long id) {
        Optional<CustomerEntity> customerOptional = repository.findById(id);

        CustomerEntity customerEntity = customerOptional
                .orElseThrow(() -> new RuntimeException("Customer not exists!"));

        return mapper.toDomain(customerEntity);
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Customer foundedCustomer = this.getCustomer(id);
        CustomerEntity customerEntity = mapper.toEntity(foundedCustomer);
        CustomerEntity saved = repository.save(customerEntity);

        return mapper.toDomain(saved);
    }

    @Override
    public Customer delete(Long id) {
        Customer foundedCustomer = this.getCustomer(id);
        CustomerEntity customerEntity = mapper.toEntity(foundedCustomer);

        CustomerEntity saved = repository
                .save(customerEntity.toBuilder()
                        .situation(StatusEntity.INACTIVE)
                        .build());

        return mapper.toDomain(saved);
    }

    @Override
    public List<PhoneNumber> changePhoneNumbers(Long id, List<PhoneNumber> phoneNumbers) {
        List<PhoneNumber> sortedPhoneNumbers = new ArrayList<>();

        if (!phoneNumbers.isEmpty()) {
            List<PhoneNumber> validatedPhoneNumbers = validatePhoneNumbers(phoneNumbers);
            sortedPhoneNumbers = sortPhoneNumbers(validatedPhoneNumbers);
        }

        Customer foundedCustomer = this.getCustomer(id);

        CustomerEntity customerEntity = mapper.toEntity(foundedCustomer.toBuilder()
                .phoneNumbers(sortedPhoneNumbers).build());

        CustomerEntity saved = repository.save(customerEntity);

        return saved.getPhoneNumbers().stream().map(mapper::toDomain).toList();
    }

    private List<PhoneNumber> sortPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        return phoneNumbers.stream()
                .sorted((o1, o2) -> o1.isMainPhoneNumber() ? -1 : 1)
                .toList();
    }

    private List<PhoneNumber> validatePhoneNumbers(List<PhoneNumber> phoneNumbers) {
        long countMainPhoneNumbers = phoneNumbers.stream()
                .filter(PhoneNumber::isMainPhoneNumber)
                .count();

        if (countMainPhoneNumbers == 0) {
            phoneNumbers.get(0).setMainPhoneNumber(true);
            return phoneNumbers;
        } else if (countMainPhoneNumbers > 1) {
            PhoneNumber phoneNumber = phoneNumbers.stream()
                    .filter(PhoneNumber::isMainPhoneNumber)
                    .toList()
                    .get(0);
            return phoneNumbers.stream()
                    .map(phoneNumber1 -> {
                        if (phoneNumber1.getId().equals(phoneNumber.getId())) {
                            phoneNumber1.setMainPhoneNumber(true);
                        } else {
                            phoneNumber1.setMainPhoneNumber(false);
                        }
                        return phoneNumber1;
                    }).toList();
        }

        return phoneNumbers;
    }
}
