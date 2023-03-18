package com.mvc.controller;

import com.mvc.exception.PlanetServiceException;
import com.mvc.request.PlanetCreationRequest;
import com.mvc.service.PlanetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlanetController {

    private PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @RequestMapping(path = "/add-planet", method = RequestMethod.GET)
    public ModelAndView getPlanetForm() {
        return new ModelAndView("planet-form.html");
    }

    @PostMapping("/add-planet")
    public String createPlanet(@RequestParam String name,
                               @RequestParam(name = "planet_type") String planetType,
                               @RequestParam int size,
                               Model model) {
        try {
            planetService.createPlanet(new PlanetCreationRequest(name, planetType, size));
            model.addAttribute("message", "Dodano plantę o nazwie: " + name);
        } catch (PlanetServiceException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "imperator-page";

    }
}
