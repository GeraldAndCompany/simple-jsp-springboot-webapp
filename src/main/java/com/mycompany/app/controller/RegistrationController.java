package com.mycompany.app.controller;

import com.mycompany.app.entity.User;
import com.mycompany.app.form.RegistrationForm;
import com.mycompany.app.service.SecurityService;
import com.mycompany.app.service.UserService;
import com.mycompany.app.validator.UserRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

    private final UserRegistrationValidator userRegistrationValidator;
    private final UserService userService;
    private final SecurityService securityService;

    @Autowired
    public RegistrationController(UserRegistrationValidator userRegistrationValidator, UserService userService, SecurityService securityService) {
        this.userRegistrationValidator = userRegistrationValidator;
        this.userService = userService;
        this.securityService = securityService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("registrationForm")RegistrationForm registrationForm, BindingResult bindingResult, Model model) {
        userRegistrationValidator.validate(registrationForm, bindingResult);
        if(bindingResult.hasErrors()){
            return "register";
        }
        User registeredUser = userService.registerUser(registrationForm);
        securityService.autoLogin(registeredUser.getUsername(), registeredUser.getPassword());
        return "redirect:/login";
    }
}
