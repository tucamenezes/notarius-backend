package model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UrlValidateur.class)
public @interface UrlValide {

    String message() default "L'url est invalide";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
