package me.tl.jpa.service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Order;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.PathBuilder;
import me.tl.jpa.config.PersistenceConfig;
import me.tl.jpa.persistence.dao.PaysDAO;
import me.tl.jpa.persistence.model.Pays;
import me.tl.jpa.persistence.model.QPays;
import me.tl.jpa.service.pays.dto.PaysProjectionDTO;
import me.tl.jpa.service.pays.dto.PaysProjectionDTOFactory;
import me.tl.jpa.service.pays.dto.QPaysProjectionDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.querydsl.QSort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class}, loader = AnnotationConfigContextLoader.class)
public class PaysDAOTests {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PaysDAO paysDAO;

    private final static QPays qPays = QPays.pays;

    @Before
    public final void before() {
    }

    @Test
    public void testFindAll() throws Exception {
        final List<Pays> all = this.paysDAO.findAll();
        Assert.assertEquals(241, all.size());
        return;

    }

    @Test
    public void testFindByAlpha2() throws Exception {
        // alpha2 = tn

        final Predicate predicate = qPays.alpha2.equalsIgnoreCase("tn");
        final Pays one = this.paysDAO.findOne(predicate);
        Assert.assertTrue(one.getFrenchName().equals("Tunisie"));
    }

    @Test
    public void testFindByAlpha3() throws Exception {
        // alpha3 = tun
        final Predicate predicate = qPays.alpha3.equalsIgnoreCase("tun");
        final Pays one = this.paysDAO.findOne(predicate);
        Assert.assertTrue(one.getFrenchName().equals("Tunisie"));
    }

    @Test
    public void testPagination() throws Exception {
        Pageable pageRequest = new PageRequest(0, 10, new Sort(Sort.Direction.ASC, "frenchName"));
        final Page<Pays> page = this.paysDAO.findAll(pageRequest);
        return;

    }

    @Test
    public void testPagination2() throws Exception {

        QSort qSort = new QSort(qPays.englishName.asc());

        PageRequest pageRequest = new PageRequest(0, 10, qSort);
        final Page<Pays> page = this.paysDAO.findAll(pageRequest);

        // 241 total
        Assert.assertEquals(241, page.getTotalElements());
        // 25 pages
        Assert.assertEquals(25, page.getTotalPages());

        return;
    }

    @Test
    public void testJPAQueryFindAll() throws Exception {

        final JPAQuery query = newJPAQuery().from(qPays);
        query.where(qPays.englishName.startsWithIgnoreCase("TU"));
        query.orderBy(qPays.alpha2.asc());

        final List<Pays> list = query.list(QPays.pays);

        final int size = list.size();

        Assert.assertEquals(5, size);
        return;

    }

    @Test
    public void testJPAQueryPagedResultWithProjection() throws Exception {

        final Pageable pageRequest = new PageRequest(0, 10);
        final JPAQuery query = newJPAQuery().from(qPays);
        final long count = query.count();
        if (count == 0) {
            return;
        }
        query
                .limit(pageRequest.getPageSize())
                .offset(pageRequest.getOffset())
                .orderBy(qPays.frenchName.asc());

        final List<PaysProjectionDTO> list = query.list(new QPaysProjectionDTO(qPays.id, qPays.frenchName));
        Page<PaysProjectionDTO> page = new PageImpl<>(list, pageRequest, count);

        final long totalElements = page.getTotalElements();

    }

    @Test
    public void testJPAQueryPagedResultWithProjection2() throws Exception {

        final Pageable pageRequest = new PageRequest(2, 10, new Sort(Sort.Direction.ASC, Pays.Fields.ENGLISH_NAME, Pays.Fields.ID));
        final JPAQuery query = newJPAQuery().from(qPays);
        final long count = query.count();
        if (count == 0) {
            return;
        }
        query
                .limit(pageRequest.getPageSize())
                .offset(pageRequest.getOffset());


        // order by
        final Sort sort = pageRequest.getSort();
        if (sort != null) {
            final PathBuilder<Pays> orderByExpression = new PathBuilder(Pays.class, QPays.pays.getMetadata());
            for (Sort.Order sortOrder : sort) {
                final boolean ascending = sortOrder.isAscending();
                Order order = (ascending) ? Order.ASC : Order.DESC;
                final PathBuilder<?> property = orderByExpression.get(sortOrder.getProperty());
                query.orderBy(new OrderSpecifier(order, property));
            }
        }

        final List<PaysProjectionDTO> list = query.list(new QPaysProjectionDTO(qPays.id, qPays.frenchName));
        Page<PaysProjectionDTO> page = new PageImpl<>(list, pageRequest, count);

        final long totalElements = page.getTotalElements();
        Assert.assertEquals(241, totalElements);
    }

    @Test
    public void testJPAQueryWithProjectionFactory() throws Exception {

        final Locale locale = Locale.ENGLISH;

        final Pageable pageRequest = new PageRequest(0, 10);
        final JPAQuery query = newJPAQuery().from(qPays);
        final long count = query.count();
        if (count == 0) {
            return;
        }
        query
                .limit(pageRequest.getPageSize())
                .offset(pageRequest.getOffset())
                .orderBy(qPays.englishName.asc());

        final List<PaysProjectionDTO> list = query.list(new PaysProjectionDTOFactory(locale));
        final Page<PaysProjectionDTO> page = new PageImpl<>(list, pageRequest, count);

        final long totalElements = page.getTotalElements();
        Assert.assertEquals(241, totalElements);
    }

    //=== utils

    private JPAQuery newJPAQuery() {
        return new JPAQuery(entityManager);
    }
}
