package model.validation;


import org.hibernate.validator.internal.constraintvalidators.hv.URLValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlValidateur extends BaseConstraintValidateur implements ConstraintValidator<UrlValide, String>{

    @Override
    public void initialize(UrlValide constraintAnnotation) {
          // Pas de tratement ici
    }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext constraintValidatorContext) {
        setConstraintValidator(constraintValidatorContext);

        if (!validerUrl(url)){
            setMessage(10001, "L'url n'est pas valide.");
            return false;
        }

        return true;
    }

    private boolean validerUrl (String url) {

        try {
            URL urlEntree = new URL(url);
            urlEntree.toURI();

            return true;
        }
        catch (URISyntaxException exception) {
            return false;
        }
        catch (MalformedURLException exception) {
            return false;
        }

    }

}
