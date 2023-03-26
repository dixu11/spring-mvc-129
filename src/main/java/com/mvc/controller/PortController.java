package com.mvc.controller;


import com.mvc.request.BuildPortRequest;
import com.mvc.responce.ImperatorResponse;
import com.mvc.service.AuthenticationService;
import com.mvc.service.PortService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class PortController {

    private PortService portService;
    private AuthenticationService authenticationService;


    public PortController(PortService portService, AuthenticationService authenticationService) {
        this.portService = portService;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/add-port")
    public String getPortForm(Model model) {
        BuildPortRequest request = new BuildPortRequest();
        Optional<ImperatorResponse> loggedImperator = authenticationService.getLoggedImperatorResponse();
        if (loggedImperator.isEmpty()) {
            model.addAttribute("message", "ZALOGUJ SIĘ!");
            return "imperator-page"; //todo redirect!
        }
        model.addAttribute("imperator", loggedImperator.get());
        model.addAttribute("request", request);
        return "port-form";
    }

    @PostMapping("/build-port")
    public String buildPort(@ModelAttribute("request") BuildPortRequest request, Model model) {
        model.addAttribute("message", "Port lvl "+request.getLvl()+"  dodany!");

        portService.createPort(request);
        return "imperator-page";
    }
}
