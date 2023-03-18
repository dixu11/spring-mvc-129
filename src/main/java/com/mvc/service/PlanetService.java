package com.mvc.service;

import com.mvc.request.PlanetCreationRequest;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

    public void createPlanet(PlanetCreationRequest request) {
        System.out.println("Tworzę planetę: " + request);
    }

}
