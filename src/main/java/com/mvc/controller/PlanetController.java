package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlanetController {

    @RequestMapping(path = "/add-planet", method = RequestMethod.GET)
    public ModelAndView getPlanetForm() {
        return new ModelAndView("planet-form.html");
    }
}
