package me.tl.jpa.service;

import me.tl.jpa.config.PersistenceConfig;
import me.tl.jpa.service.core.error.ItemNotFoundException;
import me.tl.jpa.service.pays.api.PaysService;
import me.tl.jpa.service.pays.dto.PaysDTO;
import me.tl.jpa.service.pays.dto.PaysDetailsDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Collection;

import static org.junit.Assert.fail;

/**
 * Created by thierry on 16/11/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class}, loader = AnnotationConfigContextLoader.class)
public class PaysServiceTests {

    @Autowired
    private PaysService paysService;

    @Test(expected = NullPointerException.class)
    public void testFindOne1() throws Exception {
        final PaysDetailsDTO one = this.paysService.findOne(null);
        fail();
    }

    @Test(expected = ItemNotFoundException.class)
    public void testFindOne2() throws Exception {
        this.paysService.findOne(-1L);
        fail();
    }

    @Test
    public void testFindOne3() throws Exception {
        final PaysDetailsDTO dto = this.paysService.findOne(219L);
        Assert.assertTrue("TUN".equals(dto.getAlpha3()));
    }

    @Test
    public void testFindAll1() throws Exception {
        final Collection<PaysDTO> all = this.paysService.findAll();
        Assert.assertFalse(all.isEmpty());
        Assert.assertEquals(241, all.size());
    }

    @Before
    public void setUp() throws Exception {

    }
}
