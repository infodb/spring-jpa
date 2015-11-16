package me.tl.jpa.service.pays.api;

import me.tl.jpa.service.core.error.ItemNotFoundException;
import me.tl.jpa.service.core.filter.SearchCriteria;
import me.tl.jpa.service.pays.dto.PaysDTO;
import me.tl.jpa.service.pays.dto.PaysDetailsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

/**
 * Created by thierry on 14/11/2015.
 */
public interface PaysService {

    Collection<PaysDTO> findAll(SearchCriteria criteria);

    Collection<PaysDTO> findAll();
    Page<PaysDTO> findAll(Pageable pageable);
    Page<PaysDTO> findAll(Pageable pageable, SearchCriteria criteria);
    PaysDetailsDTO findOne(Long id) throws ItemNotFoundException;



}
