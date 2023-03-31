package com.squad.customermanagement.model;

import java.time.LocalDate;
import java.util.List;

public class Customer {
    private String name;
    private Type type;
    private String federalId;
    private String rg;
    private String ie;
    private LocalDate registerDate;
    private Status situation;
    private List<String> phoneNumbers;
}
