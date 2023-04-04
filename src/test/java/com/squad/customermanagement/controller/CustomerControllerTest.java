package com.squad.customermanagement.controller;

import com.squad.customermanagement.controller.builder.CustomerRequestBuilder;
import com.squad.customermanagement.controller.builder.CustomerRequestParamsBuilder;
import com.squad.customermanagement.controller.builder.CustomerRequestParamsDTOBuilder;
import com.squad.customermanagement.controller.builder.CustomerResponseBuilder;
import com.squad.customermanagement.controller.dto.request.CustomerRequest;
import com.squad.customermanagement.controller.dto.request.CustomerRequestParamsDTO;
import com.squad.customermanagement.controller.dto.response.CustomerResponse;
import com.squad.customermanagement.controller.mapper.CustomerMapper;
import com.squad.customermanagement.service.CreateCustomerService;
import com.squad.customermanagement.service.builder.CustomerBuilder;
import com.squad.customermanagement.service.domain.Customer;
import com.squad.customermanagement.service.domain.CustomerRequestParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.HttpStatusCode.valueOf;


@SpringBootTest
class CustomerControllerTest {
    @Autowired
    private CustomerController controller;

    @MockBean
    private CreateCustomerService service;

    @MockBean
    private CustomerMapper mapper;

    private CustomerRequest request;
    private Customer customer;
    private CustomerResponse response;
    private CustomerRequestParamsDTO paramsDTO;
    private CustomerRequestParams params;

    @BeforeEach
    void setup() {
        this.request = CustomerRequestBuilder.build();
        this.customer = CustomerBuilder.build();
        this.response = CustomerResponseBuilder.build();
        this.paramsDTO = CustomerRequestParamsDTOBuilder.build();
        this.params = CustomerRequestParamsBuilder.build();
    }

    @Test
    void shouldInvokeCustomerServiceCreateMethod() {
        Customer expected = customer.toBuilder().id(1L).build();

        Mockito.when(mapper.toDomain(this.request)).thenReturn(expected);
        Mockito.when(service.create(customer)).thenReturn(expected);

        ResponseEntity<CustomerResponse> response = controller.create(this.request);

        assertTrue(response.getStatusCode().isSameCodeAs(valueOf(201)));
        Mockito.verify(service, Mockito.times(1)).create(customer);
    }

    @Test
    void shouldInvokeCustomerServiceGetAllMethod() {
        Customer expected = customer.toBuilder().id(1L).build();

        Mockito.when(service.getAll()).thenReturn(List.of(expected));
        Mockito.when(mapper.toResponse(expected)).thenReturn(response);

        ResponseEntity<List<CustomerResponse>> response = controller.getAll();

        assertTrue(response.getStatusCode().isSameCodeAs(valueOf(200)));
        Mockito.verify(service, Mockito.times(1)).getAll();
    }

    @Test
    void shouldInvokeCustomerServiceSearchByMethod() {
        Customer expected = customer.toBuilder().id(1L).build();

        int page = 0;
        int size = 10;

        Mockito.when(mapper.toDomain(paramsDTO)).thenReturn(params);
        Mockito.when(service.searchBy(params, page, size)).thenReturn(List.of(expected));
        Mockito.when(mapper.toResponse(expected)).thenReturn(response);

        ResponseEntity<Page<CustomerResponse>> response = controller
                .searchBy(this.response.getName(), this.response.getSituation(), this.response.getRegisterDate(),
                        this.response.getType(), page, size);

        assertTrue(response.getStatusCode().isSameCodeAs(valueOf(200)));
        Mockito.verify(service, Mockito.times(1)).searchBy(params, page, size);
    }

    @Test
    void shouldInvokeCustomerServiceGetByIdMethod() {
        Customer expected = customer.toBuilder().id(1L).build();

        Mockito.when(service.getById(expected.getId())).thenReturn(expected);
        Mockito.when(mapper.toResponse(expected)).thenReturn(response);

        ResponseEntity<CustomerResponse> response = controller.getById(expected.getId());

        assertTrue(response.getStatusCode().isSameCodeAs(valueOf(200)));
        Mockito.verify(service, Mockito.times(1)).getById(expected.getId());
    }

    @Test
    void shouldInvokeCustomerServiceUpdateMethod() {
        Customer expected = customer.toBuilder().id(1L).build();

        Mockito.when(service.update(expected.getId(), customer)).thenReturn(expected);
        Mockito.when(mapper.toDomain(this.request)).thenReturn(customer);

        ResponseEntity<CustomerResponse> response = controller.update(expected.getId(), this.request);

        assertTrue(response.getStatusCode().isSameCodeAs(valueOf(204)));
        Mockito.verify(service, Mockito.times(1)).update(expected.getId(), customer);
    }

    @Test
    void shouldInvokeCustomerServiceDeleteMethod() {
        Customer expected = customer.toBuilder().id(1L).build();

        Mockito.when(service.delete(expected.getId())).thenReturn(expected);

        ResponseEntity<CustomerResponse> response = controller.delete(expected.getId());

        assertTrue(response.getStatusCode().isSameCodeAs(valueOf(204)));
        Mockito.verify(service, Mockito.times(1)).delete(expected.getId());
    }
}
