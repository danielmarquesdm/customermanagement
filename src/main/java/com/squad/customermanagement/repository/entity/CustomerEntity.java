package com.squad.customermanagement.repository.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
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

    @JoinColumn(name = "phone_number_id")
    @OneToMany(cascade = CascadeType.MERGE)
    private List<PhoneNumberEntity> phoneNumbers;
}
