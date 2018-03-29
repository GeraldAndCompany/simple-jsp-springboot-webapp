package com.mycompany.app.controller.blackbox.dev;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReleaseOnePageController {
    private static final String BASE_REQ_PATH_FOR_8560905 = "/card/8560905";
    private static final String BASE_JSP_PATH_FOR_8560905 = "/public/blackbox/adding-grunt-in-maven-build";


    @RequestMapping(BASE_REQ_PATH_FOR_8560905 + "/firstModule")
    public String firstModule() {
        return BASE_JSP_PATH_FOR_8560905 + "/forModule1";
    }
    @RequestMapping(BASE_REQ_PATH_FOR_8560905 + "/secondModule")
    public String secondModule() {
        return BASE_JSP_PATH_FOR_8560905 + "/forModule2";
    }

    @RequestMapping(BASE_REQ_PATH_FOR_8560905 + "/thirdModule")
    public String thirdModule() {
        return BASE_JSP_PATH_FOR_8560905 + "/forModule3";
    }
}
