package spring.validate.validatortest.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import spring.validate.validatortest.bean.Person;

/**
 * Created by B8-02 on 2018/10/17.
 */
public class PersonValidator implements Validator {

    /**
     * This Validator validates *just* Person instances
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"name","name.empty");
        Person p = (Person)target;
        if(p.getAge()<0){
            errors.rejectValue("age","negativevalue");
        }else if(p.getAge()>120){
            errors.rejectValue("age", "too.darn.old");
        }
    }
}
