package me.tl.jpa.service.pays.dto;

import com.mysema.query.annotations.QueryProjection;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.concurrent.Immutable;

/**
 * Created by thierry on 15/11/2015.
 */
@Immutable
public class PaysProjectionDTO {

    private long id;
    private String name;

    public PaysProjectionDTO(){}

    @QueryProjection
    public PaysProjectionDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .toString();
    }
}
