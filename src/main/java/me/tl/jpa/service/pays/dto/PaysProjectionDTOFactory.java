package me.tl.jpa.service.pays.dto;

import com.mysema.query.Tuple;
import com.mysema.query.types.MappingProjection;
import com.mysema.query.types.path.StringPath;
import me.tl.jpa.persistence.model.QPays;

import java.util.Locale;


/**
 * Created by thierry on 15/11/2015.
 */
public class PaysProjectionDTOFactory extends MappingProjection<PaysProjectionDTO> {

    private final static QPays qPays = QPays.pays;
    private final StringPath path;


    public PaysProjectionDTOFactory(Locale locale) {
        super(PaysProjectionDTO.class, qPays.id, locale.equals(Locale.FRANCE)? qPays.frenchName : qPays.englishName);
        path = locale.equals(Locale.FRANCE) ? qPays.frenchName : qPays.englishName;
    }

    @Override
    protected PaysProjectionDTO map(Tuple tuple) {
        return new PaysProjectionDTO(tuple.get(qPays.id), tuple.get(path));
    }
}
