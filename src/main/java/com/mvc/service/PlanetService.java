package com.mvc.service;

import com.mvc.entity.Planet;
import com.mvc.entity.PlanetType;
import com.mvc.exception.PlanetServiceException;
import com.mvc.repository.PlanetRepository;
import com.mvc.request.PlanetCreationRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PlanetService {
    private PlanetRepository repository;

    public PlanetService(   PlanetRepository repository) {
        this.repository = repository;
    }

    public void createPlanet(PlanetCreationRequest request) {
        if (request.getName().isBlank()) {
            throw new PlanetServiceException("Nie uzupełniono nazwy!");
        } else if (request.getSize()<= 0) {
            throw new PlanetServiceException("Rozmiar planety min. 1");
        }

        PlanetType type = PlanetType.valueOf(request.getType());
        Planet planet = new Planet(request.getName(), type, request.getSize());
        repository.save(planet);
    }

    public List<Planet> getAllPlanets() {
      return repository.findAll();
    }
}
