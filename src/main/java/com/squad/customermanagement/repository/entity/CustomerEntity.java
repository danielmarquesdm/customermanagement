package com.squad.customermanagement.repository.entity;

import com.squad.customermanagement.repository.CnpjGroup;
import com.squad.customermanagement.repository.CpfGroup;
import com.squad.customermanagement.repository.CustomerGroupSequenceProvider;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@GroupSequenceProvider(CustomerGroupSequenceProvider.class)
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private TypeEntity type;

    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    @Column(unique = true)
    private String federalId;
    private String rg;
    private String ie;
    private LocalDate registerDate;
    private StatusEntity situation;

    @JoinColumn(name = "phone_number_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<PhoneNumberEntity> phoneNumbers;
}
