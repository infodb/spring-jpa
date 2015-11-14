package me.tl.jpa.persistence.model;

import javax.persistence.*;

/**
 * Created by thierry on 13/11/2015.
 */
@Entity
@Table(name = "developer")
public class Developer extends NamedEntity {

    @Embedded
    private Person person;

    @Enumerated(EnumType.STRING)
    private DeveloperRole role;
    private boolean active;

    @Embedded
    private Contact contact;


    public Developer() {

    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public DeveloperRole getRole() {
        return role;
    }

    public void setRole(DeveloperRole role) {
        this.role = role;
    }
}
