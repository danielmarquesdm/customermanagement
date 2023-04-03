package com.squad.customermanagement.repository.impl;

import com.squad.customermanagement.repository.CustomerQueryRepository;
import com.squad.customermanagement.repository.entity.CustomerEntity;
import com.squad.customermanagement.repository.entity.CustomerRequestParamsEntity;
import com.squad.customermanagement.repository.entity.StatusEntity;
import com.squad.customermanagement.repository.entity.TypeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerQueryRepositoryImpl implements CustomerQueryRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<CustomerEntity> findAllByParameters(CustomerRequestParamsEntity params) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<CustomerEntity> criteriaQuery = builder.createQuery(CustomerEntity.class);

        Root<CustomerEntity> root = criteriaQuery.from(CustomerEntity.class);

        var predicates = new ArrayList<Predicate>();

        String name = params.getName();
        StatusEntity situation = params.getSituation();
        LocalDate registrationDate = params.getRegisterDate();
        TypeEntity type = params.getType();

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

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<CustomerEntity> query = manager.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
