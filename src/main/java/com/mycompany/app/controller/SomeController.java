package com.mycompany.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SomeController {

    @Value("${some.message: some message}")
    private String someMessage;

    @RequestMapping("/")
    public ModelAndView baseDirectory(){
        return new ModelAndView("index", "message", someMessage);
    }

    @RequestMapping("/somePath")
    public ModelAndView getSomePath(){
        return new ModelAndView("index", "message", someMessage);
    }
}
