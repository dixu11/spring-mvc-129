package com.mvc.controller;


import com.mvc.request.BuildPortRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PortController {
    @GetMapping("/add-port")
    public String getPortForm(Model model) {
        BuildPortRequest request = new BuildPortRequest();
        model.addAttribute("request", request);
        return "port-form";
    }

    @PostMapping("/build-port")
    public String buildPort(@ModelAttribute("request") BuildPortRequest request, Model model) {
        model.addAttribute("message", "Port lvl "+request.getLvl()+"  dodany!");
        return "imperator-page";
    }
}
