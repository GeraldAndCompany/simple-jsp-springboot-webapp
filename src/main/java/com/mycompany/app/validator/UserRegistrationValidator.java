package com.mycompany.app.validator;

import com.mycompany.app.form.RegistrationForm;
import com.mycompany.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserRegistrationValidator implements Validator {
    private final UserRepository userRepository;

    @Autowired
    public UserRegistrationValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return RegistrationForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegistrationForm registrationForm = (RegistrationForm) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty");
        if(userRepository.findByUsername(registrationForm.getUsername()) != null) {
            errors.reject("username", "Duplicate.registrationForm.username");
        }
        if(!registrationForm.getPassword().equals(registrationForm.getConfirmPassword())){
            errors.reject("confirmPassword", "NotMatch.registrationForm.confirmPassword");
        }
    }
}
