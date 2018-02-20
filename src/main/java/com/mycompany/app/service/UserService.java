package com.mycompany.app.service;

import com.mycompany.app.entity.User;
import com.mycompany.app.form.RegistrationForm;

public interface UserService {
    User registerUser(RegistrationForm registrationForm);
    User findByUsername(String username);
}