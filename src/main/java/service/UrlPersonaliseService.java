package service;

import model.UrlPersonalise;


public interface UrlPersonaliseService {

    UrlPersonalise enregistreUrlPersonalise(UrlPersonalise urlPersonalise) throws Exception;

    UrlPersonalise getUrlPersonaliseParId(Long id) throws Exception;

    UrlPersonalise getUrlPersonaliseParCle(String cle) throws Exception;

    boolean verifierUrlPersonaliseExiste(UrlPersonalise urlPersonalise) throws Exception;


}
