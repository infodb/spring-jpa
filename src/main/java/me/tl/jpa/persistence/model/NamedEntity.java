package me.tl.jpa.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/**
 * Created by thierry on 13/11/2015.
 */
@MappedSuperclass
public abstract class NamedEntity extends BasicEntity {
    @Column(name = "name_")
    protected String name;

    public NamedEntity() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
