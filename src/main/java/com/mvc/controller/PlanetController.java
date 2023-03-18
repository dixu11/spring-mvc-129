package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlanetController {

    @RequestMapping(path = "/add-planet", method = RequestMethod.GET)
    public ModelAndView getPlanetForm() {
        return new ModelAndView("planet-form.html");
    }

    @PostMapping("/add-planet")
    public String createPlanet(@RequestParam String name,
                               @RequestParam(name = "planet_type") String planetType,
                               @RequestParam int size) {
        System.out.println(name);
        System.out.println(planetType);
        System.out.println(size);
        return "imperator-page";
    }
}
