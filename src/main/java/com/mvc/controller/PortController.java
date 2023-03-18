package com.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortController {
    @GetMapping( "/add-port")
    public String getPortForm() {
        return "port-form";
    }
}
