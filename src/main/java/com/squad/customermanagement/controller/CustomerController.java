package com.squad.customermanagement.controller;

import com.squad.customermanagement.controller.dto.CustomerRequestDTO;
import com.squad.customermanagement.controller.mapper.CustomerMapper;
import com.squad.customermanagement.service.domain.Customer;
import com.squad.customermanagement.service.CreateCustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CreateCustomerService service;
    private CustomerMapper mapper;

    @PostMapping
    public void create(CustomerRequestDTO request) {
        Customer customer = mapper.toDomain(request);
        service.create(customer);
    }
}
