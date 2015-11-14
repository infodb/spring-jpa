package me.tl.jpa.persistence.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Embeddable;
import javax.validation.Valid;

/**
 * Created by thierry on 14/11/2015.
 */
@Embeddable
public class Contact {

    @Valid
    @Email
    private String emailAdress;
    private String phoneNumber;

    public Contact(){}


    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
