package me.tl.jpa.persistence.dao.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by thierry on 14/11/2015.
 */
abstract class AbstractRepository {

    @PersistenceContext
    private EntityManager entityManager;

    protected AbstractRepository(){

    }
    protected EntityManager getEntityManager(){
        return entityManager;
    }
}
