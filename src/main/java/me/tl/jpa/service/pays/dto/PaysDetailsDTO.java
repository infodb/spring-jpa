package me.tl.jpa.service.pays.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by thierry on 14/11/2015.
 */
public class PaysDetailsDTO extends PaysDTO {
    private static final long serialVersionUID = 5411913825419094888L;
    private String alpha2;
    private String alpha3;

    public PaysDetailsDTO() {
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha3(String alpha3) {
        this.alpha3 = alpha3;
    }

    public String getAlpha3() {
        return alpha3;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("alpha2", alpha2)
                .append("alpha3", alpha3)
                .toString();
    }
}
