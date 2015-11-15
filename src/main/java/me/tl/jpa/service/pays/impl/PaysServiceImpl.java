package me.tl.jpa.service.pays.impl;

import me.tl.jpa.persistence.dao.PaysDAO;
import me.tl.jpa.service.pays.api.PaysService;
import me.tl.jpa.service.pays.dto.PaysDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Locale;

/**
 * Created by thierry on 14/11/2015.
 */
@Service
public class PaysServiceImpl implements PaysService {

    private final PaysDAO dao;
    private final Locale locale = Locale.getDefault();

    private final Logger logger = LoggerFactory.getLogger("service");

    @Autowired
    public PaysServiceImpl(PaysDAO paysDAO){
        this.dao = paysDAO;
    }

    @Override
    public Collection<PaysDTO> findAll() {
        return null;
    }

    @Override
    public Page<PaysDTO> findAll(Pageable pageable) {
        return null;
    }
}
