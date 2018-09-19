package model;

import model.validation.UrlValide;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UrlPersonalise {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String cleUrl;
    @UrlValide
    private String urlOriginale;


    public UrlPersonalise() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCleUrl() {
        return cleUrl;
    }

    public void setCleUrl(String cleUrl) {
        this.cleUrl = cleUrl;
    }

    public String getUrlOriginale() {
        return urlOriginale;
    }

    public void setUrlOriginale(String urlOriginale) {
        this.urlOriginale = urlOriginale;
    }

}
