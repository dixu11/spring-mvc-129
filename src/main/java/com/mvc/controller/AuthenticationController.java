package com.mvc.controller;

import com.mvc.exception.AuthenticationServiceException;
import com.mvc.request.LoginRequest;
import com.mvc.request.RegisterRequest;
import com.mvc.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
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
        try {
            authenticationService.createImperator(request);
            modelAndView.addObject("message", "Konto utworzone, podbijamy kosmos!");
        } catch (AuthenticationServiceException e) {
            modelAndView.addObject("message", e.getMessage());
        }
        return modelAndView;
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        LoginRequest loginRequest = new LoginRequest();
        model.addAttribute("request",loginRequest);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("request") LoginRequest loginRequest, Model model) {
        try {
            authenticationService.loginImperator(loginRequest);
            model.addAttribute("message", "Zostałeś poprawnie zalogowany!");
        } catch (AuthenticationServiceException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "imperator-page";
    }

}
