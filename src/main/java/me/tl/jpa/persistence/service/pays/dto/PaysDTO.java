package me.tl.jpa.persistence.service.pays.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by thierry on 14/11/2015.
 */
public class PaysDTO implements Serializable{

    private static final long serialVersionUID = -6933897874067591517L;

    protected long id;
    protected String name;

    public PaysDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .toString();
    }
}
