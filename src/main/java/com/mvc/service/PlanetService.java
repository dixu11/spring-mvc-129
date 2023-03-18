package com.mvc.service;

import com.mvc.exception.PlanetServiceException;
import com.mvc.request.PlanetCreationRequest;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

    public void createPlanet(PlanetCreationRequest request) {
        if (request.getName().isBlank()) {
            throw new PlanetServiceException("Nie uzupełniono nazwy!");
        } else if (request.getSize()<= 0) {
            throw new PlanetServiceException("Rozmiar planety min. 1");
        }
        System.out.println("Wszystko ok, dodaję");
        //dodawanie do bazy danych
    }

}
