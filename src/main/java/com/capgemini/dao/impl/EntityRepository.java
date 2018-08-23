package com.capgemini.dao.impl;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class EntityRepository<T> implements CrudRepository<T, Long> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> domainClass;


}
