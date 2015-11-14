package me.tl.jpa.persistence.service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;
import me.tl.jpa.config.PersistenceConfig;
import me.tl.jpa.persistence.dao.PaysDAO;
import me.tl.jpa.persistence.model.Pays;
import me.tl.jpa.persistence.model.QPays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QSort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class PaysDAOTests {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PaysDAO paysDAO;

    private final QPays qPays = QPays.pays;

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
        PageRequest pageRequest  = new PageRequest(0, 10, new Sort(Sort.Direction.ASC, "frenchName"));
        final Page<Pays> page = this.paysDAO.findAll(pageRequest);
        return;

    }

    @Test
    public void testPagination2() throws Exception {

        QSort qSort = new QSort(qPays.englishName.asc());

        PageRequest pageRequest  = new PageRequest(0, 10, qSort);
        final Page<Pays> page = this.paysDAO.findAll(pageRequest);
        return;
    }

    @Test
    public void testName() throws Exception {

        JPAQuery query = new JPAQuery(entityManager).from(qPays);
        query.where(qPays.englishName.startsWithIgnoreCase("TU"));
        query.orderBy(qPays.alpha2.asc());

        final List<Pays> list = query.list(QPays.pays);

        return;

    }
}
