package com.squad.customermanagement.repository;

import com.squad.customermanagement.controller.dto.StatusDTO;
import com.squad.customermanagement.controller.dto.TypeDTO;
import com.squad.customermanagement.repository.entity.CustomerEntity;

import java.time.LocalDate;
import java.util.List;

public interface CustomerQueryRepository {
    List<CustomerEntity> findAllByParameters(String name, StatusDTO situation, LocalDate registrationDate, TypeDTO type);
}
