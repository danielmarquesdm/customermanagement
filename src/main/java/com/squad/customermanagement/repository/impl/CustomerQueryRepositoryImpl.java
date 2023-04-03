package com.squad.customermanagement.repository.impl;

import com.squad.customermanagement.controller.dto.StatusDTO;
import com.squad.customermanagement.controller.dto.TypeDTO;
import com.squad.customermanagement.repository.CustomerQueryRepository;
import com.squad.customermanagement.repository.entity.CustomerEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerQueryRepositoryImpl implements CustomerQueryRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<CustomerEntity> findAllByParameters(String name, StatusDTO situation, LocalDate registrationDate, TypeDTO type) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<CustomerEntity> criteriaQuery = builder.createQuery(CustomerEntity.class);

        Root<CustomerEntity> root = criteriaQuery.from(CustomerEntity.class);

        var predicates = new ArrayList<Predicate>();

        if (StringUtils.hasText(name)) {
            Predicate namePredicate = builder.like(root.get("name"), "%" + name + "%");
            predicates.add(namePredicate);
        }

        if (situation != null) {
            Predicate statusPredicate = builder.equal(root.get("situation"), situation);
            predicates.add(statusPredicate);
        }

        if (registrationDate != null) {
            Predicate registrationDatePredicate = builder.equal(root.get("registerDate"), registrationDate);
            predicates.add(registrationDatePredicate);
        }

        if (type != null) {
            Predicate typePredicate = builder.equal(root.get("type"), type);
            predicates.add(typePredicate);
        }

        if (predicates.isEmpty()) {
            return Collections.emptyList();
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<CustomerEntity> query = manager.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
