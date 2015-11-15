package me.tl.jpa.persistence.dao.repository;

import me.tl.jpa.persistence.dao.DAO;
import me.tl.jpa.persistence.model.Pays;
import me.tl.jpa.persistence.model.QPays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by thierry on 14/11/2015.
 */
@Repository
public class PaysRepository extends AbstractRepository{


    private final DAO<Pays> dao;

    private final QPays qPays = QPays.pays;

    @Autowired
    public PaysRepository(DAO<Pays> dao){
        super();
        this.dao = dao;
    }



}
