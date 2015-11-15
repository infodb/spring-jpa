package me.tl.jpa.persistence.model;

import javax.persistence.*;

/**
 * Created by thierry on 14/11/2015.
 */
@Entity
@Table(name = "pays")
@Access(AccessType.FIELD)
public class Pays extends BasicEntity{

    /*

    CREATE TABLE IF NOT EXISTS `pays` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `code` int(3) NOT NULL,
  `alpha2` varchar(2) NOT NULL,
  `alpha3` varchar(3) NOT NULL,
  `nom_en_gb` varchar(45) NOT NULL,
  `nom_fr_fr` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),

//-->TODO
  UNIQUE KEY `alpha2` (`alpha2`),
  UNIQUE KEY `alpha3` (`alpha3`),
  UNIQUE KEY `code_unique` (`code`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=242 ;

     */


    private int code;
    private String alpha2;
    private String alpha3;
    @Column(name = "nom_en_gb")
    private String englishName;
    @Column(name = "nom_fr_fr")
    private String frenchName;

    public Pays(){


    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getAlpha3() {
        return alpha3;
    }

    public void setAlpha3(String alpha3) {
        this.alpha3 = alpha3;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getFrenchName() {
        return frenchName;
    }

    public void setFrenchName(String frenchName) {
        this.frenchName = frenchName;
    }


    @Override
    public String toString() {
        return "me.tl.jpa.persistence.model.Pays{" +
                "alpha2='" + alpha2 + '\'' +
                ", code=" + code +
                ", alpha3='" + alpha3 + '\'' +
                ", englishName='" + englishName + '\'' +
                ", frenchName='" + frenchName + '\'' +
                "} " + super.toString();
    }

    public interface Fields {
        String FRENCH_NAME = "frenchName";
        String ENGLISH_NAME = "englishName";
        String ID = "id";
    }
}
