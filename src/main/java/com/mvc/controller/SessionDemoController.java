package com.mvc.controller;

import com.mvc.service.AuthenticationService;
import com.mvc.session.ImperatorSession;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class SessionDemoController {

    private AuthenticationService service;


    public SessionDemoController(AuthenticationService service) {
        this.service = service;
    }

    @GetMapping("/session-info")
    public String getSessionInfo(HttpSession session, Model model) {



        if (session.getAttribute("message") == null) {
            session.setAttribute("message","test - " + new Random().nextInt());
        }

        model.addAttribute("sessionMessage",   session.getAttribute("message"));
        return "session";
    }


}
