package model.validation;


import javax.validation.ConstraintValidatorContext;

public class BaseConstraintValidateur {

    private ConstraintValidatorContext constraintValidator;

    public ConstraintValidatorContext getConstraintValidator() {
        return constraintValidator;
    }

    public void setConstraintValidator(ConstraintValidatorContext constraintValidator) {
        this.constraintValidator = constraintValidator;
    }

    public void setMessage(Integer code, String message) {

        if (constraintValidator == null) {
           throw new UnsupportedOperationException("Le context ConstraintValidatorContext est null");
        }

        constraintValidator.disableDefaultConstraintViolation();
        constraintValidator.buildConstraintViolationWithTemplate(code + ":" + message).addConstraintViolation();
    }
}
