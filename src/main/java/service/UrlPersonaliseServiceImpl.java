package service;


import Util.HelperUrlPersonalise;
import model.UrlPersonalise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.UrlPersonaliseRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class UrlPersonaliseServiceImpl implements UrlPersonaliseService {

    @Autowired
    private UrlPersonaliseRepository urlPersonaliseRepository;

    @PersistenceContext
    EntityManager em;

    @Override
    public UrlPersonalise enregistreUrlPersonalise(UrlPersonalise urlPersonalise) throws Exception {

        if (verifierUrlPersonaliseExiste(urlPersonalise)) {
            urlPersonaliseRepository.save(urlPersonalise);
            urlPersonalise.setCleUrl(genererCleUrl(urlPersonalise.getId()));
            urlPersonaliseRepository.save(urlPersonalise);
        } else {
            urlPersonalise = getUrlPersonaliseparUrlOriginal(urlPersonalise.getUrlOriginale());

        }

        return urlPersonalise;
    }

    @Override
    public UrlPersonalise getUrlPersonaliseParId(Long id) throws Exception {

        return urlPersonaliseRepository.findById(id).get();
    }

    @Override
    public UrlPersonalise getUrlPersonaliseParCle(String cle) throws Exception {

        String sqlgerUrlparCle = "from UrlPersonalise a where a.cleUrl = :cleUrlPersonalise";

        Query query = em
                .createQuery(sqlgerUrlparCle)
                .setParameter("cleUrlPersonalise", cle);

        UrlPersonalise urlPersonalise = new UrlPersonalise();

        if (!CollectionUtils.isEmpty(query.getResultList())) {
            urlPersonalise = (UrlPersonalise) query.getResultList().get(0);
        }

        return urlPersonalise;
    }

    @Override
    public boolean verifierUrlPersonaliseExiste(UrlPersonalise urlPersonalise) throws Exception {

        return !isNull(getUrlPersonaliseparUrlOriginal(urlPersonalise.getUrlOriginale()));
    }

    //@Override
    public UrlPersonalise getUrlPersonaliseparUrlOriginal(String url) throws Exception {

        UrlPersonalise urlPersonalise = null;
        String sqlVerifierUrl = "from UrlPersonalise a where a.urlOriginale = :url";


        Query query = em
                .createQuery(sqlVerifierUrl)
                .setParameter("url", url);

        if (!CollectionUtils.isEmpty(query.getResultList())) {
            urlPersonalise =  (UrlPersonalise) query.getResultList().get(0);
        }

        return urlPersonalise;
    }

    private String genererCleUrl (Long id) {

      return HelperUrlPersonalise.genererCleUrl(id);
    }

    private boolean isNull (Object o) {
        return o != null ? true : false;
    }

}
