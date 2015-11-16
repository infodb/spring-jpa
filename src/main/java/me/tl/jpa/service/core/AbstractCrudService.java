package me.tl.jpa.service.core;

import com.mysema.query.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by thierry on 15/11/2015.
 */
public abstract class AbstractCrudService implements CrudService{

    @PersistenceContext
    protected EntityManager entityManager;


    protected AbstractCrudService(){}

    protected EntityManager getEntityManager(){
        return entityManager;
    }

    protected JPAQuery newJpaQuery(){
        return new JPAQuery(entityManager);
    }

    protected abstract long countAll();
}
