package me.tl.jpa.persistence.dao;

import me.tl.jpa.persistence.model.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by thierry on 14/11/2015.
 */
@Repository
public interface PaysDAO extends DAO<Pays> {
}
