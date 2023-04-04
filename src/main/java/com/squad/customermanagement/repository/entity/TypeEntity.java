package com.squad.customermanagement.repository.entity;

import com.squad.customermanagement.repository.CnpjGroup;
import com.squad.customermanagement.repository.CpfGroup;

public enum TypeEntity {
    NATURAL_PERSON("Pessoa Física", "CPF", "000.000.000-00", CpfGroup.class),
    LEGAL_PERSON("Pessoa Jurídica", "CNPJ", "00.000.000/0000-00", CnpjGroup.class);

    private final String description;
    private final String type;
    private final String mask;
    private final Class<?> validationGroup;

    TypeEntity(String description, String type, String mask, Class<?> validationGroup) {
        this.description = description;
        this.type = type;
        this.mask = mask;
        this.validationGroup = validationGroup;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getMask() {
        return mask;
    }

    public Class<?> getValidationGroup() {
        return validationGroup;
    }

}
