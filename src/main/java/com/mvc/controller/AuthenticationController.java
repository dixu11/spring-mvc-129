package com.mvc.controller;

import com.mvc.request.RegisterRequest;
import com.mvc.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

    private AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage() {
        RegisterRequest request = new RegisterRequest();
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("request", request);
        return modelAndView;
    }

    @PostMapping("/create-imperator")
    public ModelAndView createImperator(@ModelAttribute("request") RegisterRequest request) {
        ModelAndView modelAndView = new ModelAndView("imperator-page");
        modelAndView.addObject("request", request);
        service.createImperator(request);
        modelAndView.addObject("message", "Konto utworzone, podbijamy kosmos!");
        return modelAndView;
    }

}
