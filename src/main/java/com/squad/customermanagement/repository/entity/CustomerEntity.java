package com.squad.customermanagement.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "customer")
@Data
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private TypeEntity type;
    private String federalId;
    private String rg;
    private String ie;
    private LocalDate registerDate;
    private StatusEntity situation;
    private String phoneNumber;
}
