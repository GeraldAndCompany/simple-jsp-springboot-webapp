package com.mycompany.app.controller;

import com.mycompany.app.form.LoginForm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if(error != null) {
            model.addAttribute("error", "Your username and password combination is invalid.");
        } else if(logout != null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if(authentication.getDetails() instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) authentication.getDetails();
                model.addAttribute("message", userDetails.getUsername() + " has been logged out.");
                authentication.setAuthenticated(false);
            }
        }
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }
}
