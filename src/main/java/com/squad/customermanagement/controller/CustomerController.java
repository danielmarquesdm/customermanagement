package com.squad.customermanagement.controller;

import com.squad.customermanagement.controller.dto.CustomerRequest;
import com.squad.customermanagement.controller.dto.CustomerRequestParamsDTO;
import com.squad.customermanagement.controller.dto.CustomerResponse;
import com.squad.customermanagement.controller.dto.PhoneNumberDTO;
import com.squad.customermanagement.controller.mapper.CustomerMapper;
import com.squad.customermanagement.service.CreateCustomerService;
import com.squad.customermanagement.service.domain.Customer;
import com.squad.customermanagement.service.domain.CustomerRequestParams;
import com.squad.customermanagement.service.domain.PhoneNumber;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CreateCustomerService service;
    @Autowired
    private CustomerMapper mapper;

    public CustomerController(CreateCustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody @Valid CustomerRequest request) {
        Customer customer = mapper.toDomain(request);
        Customer created = service.create(customer);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(created));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAll(@RequestParam CustomerRequestParamsDTO requestParamsDTO) {
        CustomerRequestParams requestParams = mapper.toDomain(requestParamsDTO);
        List<CustomerResponse> allCustomers = service.getAll(requestParams)
                .stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.ok(allCustomers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable Long id) {
        Customer customer = service.getById(id);
        return ResponseEntity.ok(mapper.toResponse(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable Long id,
                                                   @RequestBody @Valid CustomerRequest request) {
        Customer customer = mapper.toDomain(request);
        service.update(id, customer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerResponse> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<List<PhoneNumberDTO>> changePhoneNumber(@PathVariable Long id,
                                                                  @RequestBody List<PhoneNumberDTO> requestPhoneNumbers) {
        List<PhoneNumber> phoneNumbers = requestPhoneNumbers.stream().map(mapper::toDomain).toList();

        List<PhoneNumber> updatedPhoneNumbers = service.changePhoneNumbers(id, phoneNumbers);

        return ResponseEntity.ok(updatedPhoneNumbers.stream()
                .map(mapper::toResponse).toList());
    }
}
