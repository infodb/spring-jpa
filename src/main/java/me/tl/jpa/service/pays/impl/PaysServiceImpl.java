package me.tl.jpa.service.pays.impl;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.mysema.query.types.Order;
import com.mysema.query.types.OrderSpecifier;
import me.tl.jpa.persistence.dao.PaysDAO;
import me.tl.jpa.persistence.model.Pays;
import me.tl.jpa.persistence.model.QPays;
import me.tl.jpa.service.core.AbstractCrudService;
import me.tl.jpa.service.core.error.ItemNotFoundException;
import me.tl.jpa.service.core.filter.SearchCriteria;
import me.tl.jpa.service.pays.api.PaysService;
import me.tl.jpa.service.pays.dto.PaysDTO;
import me.tl.jpa.service.pays.dto.PaysDetailsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/**
 * Created by thierry on 14/11/2015.
 */
@Service
public class PaysServiceImpl extends AbstractCrudService implements PaysService {

    private final PaysDAO dao;

    private final Logger logger = LoggerFactory.getLogger("service");

    @Autowired
    public PaysServiceImpl(PaysDAO paysDAO){
        this.dao = paysDAO;
    }

    @Override
    public Collection<PaysDTO> findAll(SearchCriteria criteria) {
        return null;
    }

    @Override
    public Collection<PaysDTO> findAll() {
        final Iterable<Pays> all = this.dao.findAll(new OrderSpecifier<>(Order.ASC, QPays.pays.frenchName));

        Collection<PaysDTO> dtos = new ArrayList<>();
        final Function<Pays, PaysDetailsDTO> detailDTOMapper = getDetailDTOMapper();

        for(Iterator<Pays> iterator = all.iterator(); iterator.hasNext();){
            final Pays pays = iterator.next();
            final PaysDetailsDTO dto = detailDTOMapper.apply(pays);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public Page<PaysDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<PaysDTO> findAll(Pageable pageable, SearchCriteria criteria) {
        return null;
    }

    @Override
    public PaysDetailsDTO findOne(Long id) throws ItemNotFoundException {
        Preconditions.checkNotNull(id);

        final Pays pays = this.dao.findOne(id);
        if(pays == null){
            throw new ItemNotFoundException("le pays possédant l'identifiant #"+id+" n'existe pas");
        }
        return getDetailDTOMapper().apply(pays);
    }




    @Override
    protected long countAll() {
        return dao.count();
    }

    private Function<Pays, PaysDetailsDTO> getDetailDTOMapper(){

        return new Function<Pays, PaysDetailsDTO>() {
            @Nullable
            @Override
            public PaysDetailsDTO apply(Pays pays) {
                final PaysDetailsDTO dto = new PaysDetailsDTO();
                dto.setId(pays.getId());
                dto.setName(pays.getFrenchName());
                dto.setAlpha2(pays.getAlpha2());
                dto.setAlpha3(pays.getAlpha3());
                return dto;
            }
        };
    }
}
