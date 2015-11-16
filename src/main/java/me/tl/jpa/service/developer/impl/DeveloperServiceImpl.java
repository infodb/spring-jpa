package me.tl.jpa.service.developer.impl;

import me.tl.jpa.persistence.dao.repository.DeveloperRepository;
import me.tl.jpa.service.core.AbstractCrudService;
import me.tl.jpa.service.developer.api.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by thierry on 14/11/2015.
 */

@Service
@Transactional
public class DeveloperServiceImpl extends AbstractCrudService implements DeveloperService {

    private final DeveloperRepository repository;

    @Autowired
    public DeveloperServiceImpl(DeveloperRepository repository){
        this.repository = repository;
    }

    @Override
    protected long countAll() {
        return 0L;
    }
}
