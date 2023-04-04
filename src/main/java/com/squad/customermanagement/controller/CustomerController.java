package com.squad.customermanagement.controller;

import com.squad.customermanagement.controller.dto.StatusDTO;
import com.squad.customermanagement.controller.dto.TypeDTO;
import com.squad.customermanagement.controller.dto.request.CustomerRequest;
import com.squad.customermanagement.controller.dto.request.CustomerRequestParamsDTO;
import com.squad.customermanagement.controller.dto.request.PhoneNumberRequestDTO;
import com.squad.customermanagement.controller.dto.response.CustomerResponse;
import com.squad.customermanagement.controller.dto.response.PhoneNumberResponseDTO;
import com.squad.customermanagement.controller.mapper.CustomerMapper;
import com.squad.customermanagement.service.CreateCustomerService;
import com.squad.customermanagement.service.domain.Customer;
import com.squad.customermanagement.service.domain.CustomerRequestParams;
import com.squad.customermanagement.service.domain.PhoneNumber;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
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
                .build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAll() {
        List<CustomerResponse> allCustomers = service.getAll()
                .stream()
                .map(mapper::toResponse)
                .toList();

        return ResponseEntity.ok(allCustomers);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<CustomerResponse>> searchBy(@RequestParam(value = "name", required = false) String name,
                                                           @RequestParam(value = "status", required = false) StatusDTO situation,
                                                           @RequestParam(value = "registrationDate", required = false) LocalDate registrationDate,
                                                           @RequestParam(value = "type", required = false) TypeDTO type,
                                                           @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        CustomerRequestParamsDTO paramsDTO = CustomerRequestParamsDTO.builder()
                .name(name)
                .situation(situation)
                .registerDate(registrationDate)
                .type(type)
                .build();

        CustomerRequestParams params = mapper.toDomain(paramsDTO);

        List<CustomerResponse> allCustomers = service.searchBy(params, page, pageSize)
                .stream()
                .map(mapper::toResponse)
                .toList();

        return ResponseEntity.ok(new PageImpl<>(allCustomers, Pageable.ofSize(pageSize), page));
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

    @PutMapping("/{id}/phone-numbers")
    public ResponseEntity<List<PhoneNumberResponseDTO>> changePhoneNumber(@PathVariable Long id,
                                                                          @RequestBody List<PhoneNumberRequestDTO> requestPhoneNumbers) {
        List<PhoneNumber> phoneNumbers = requestPhoneNumbers.stream().map(mapper::toDomain).toList();

        List<PhoneNumber> updatedPhoneNumbers = service.changePhoneNumbers(id, phoneNumbers);

        return ResponseEntity.ok(updatedPhoneNumbers.stream()
                .map(mapper::toResponse).toList());
    }
}
