package me.tl.jpa.persistence.model;

import javax.persistence.MappedSuperclass;

/**
 * Created by thierry
 * on 05/12/2015.
 */

@MappedSuperclass
public abstract class AbstractReferentialItem extends BasicEntity implements ReferentialItem {

    protected int order;
    protected String description;
    protected String name;
    protected String shortName;
    protected boolean enabled;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getShortName() {
        return shortName;
    }

    @Override
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

}
