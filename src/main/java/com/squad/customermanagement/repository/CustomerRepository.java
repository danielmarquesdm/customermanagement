package com.squad.customermanagement.repository;

import com.squad.customermanagement.service.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
