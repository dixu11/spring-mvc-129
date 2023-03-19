package com.mvc.controller;

import com.mvc.entity.Planet;
import com.mvc.exception.PlanetServiceException;
import com.mvc.request.PlanetCreationRequest;
import com.mvc.request.PlanetFilterRequest;
import com.mvc.responce.PlanetResponse;
import com.mvc.service.PlanetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
                               @RequestParam long population,
                               Model model) {
        try {
            planetService.createPlanet(new PlanetCreationRequest(name, planetType, population));
            model.addAttribute("message", "Dodano plantę o nazwie: " + name);
        } catch (PlanetServiceException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "imperator-page";
    }

    @GetMapping("/find-planet")
    public String getFindPlanetPage(Model model) {
       //czy na pewno encja w kontrolerze? architektura warstw!!
        model.addAttribute("request", new PlanetFilterRequest());
        List<PlanetResponse> planets =  planetService.getAllPlanets();
        model.addAttribute("planets", planets);
        return "find-planet";
    }

    @PostMapping("/find-planet")
    public String filteredFindPlanetPage(
            @ModelAttribute("request") PlanetFilterRequest request,
            Model model) {
        List<PlanetResponse> planets =  planetService.getPlanets(request);
        model.addAttribute("planets", planets);
        return "find-planet";
    }
}
