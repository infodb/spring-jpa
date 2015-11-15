package me.tl.jpa.service.pays.api;

import me.tl.jpa.service.pays.dto.PaysDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

/**
 * Created by thierry on 14/11/2015.
 */
public interface PaysService {

    Collection<PaysDTO> findAll();
    Page<PaysDTO> findAll(Pageable pageable);
}
