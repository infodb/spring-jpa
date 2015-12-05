package me.tl.jpa.persistence.model;

import org.springframework.data.domain.Persistable;

/**
 * Created by thierry
 * on 05/12/2015.
 */
public interface ReferentialItem extends Persistable<Long>, SecuredObject {

    boolean isEnabled();
    void setEnabled(boolean enabled);
    int getOrder();
    void setOrder(int order);
    String getDescription();
    void setDescription(String description);
    String getName();
    void setName(String name);
    String getShortName();
    void setShortName(String shortName);

}
