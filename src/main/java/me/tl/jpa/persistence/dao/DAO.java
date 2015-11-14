package me.tl.jpa.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by thierry on 14/11/2015.
 */
@NoRepositoryBean
public interface DAO<BO> extends JpaRepository<BO, Long>, QueryDslPredicateExecutor<BO> {
}
