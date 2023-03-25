package com.mvc.service;

import com.mvc.entity.Planet;
import com.mvc.entity.PlanetType;
import com.mvc.exception.PlanetServiceException;
import com.mvc.repository.PlanetRepository;
import com.mvc.request.PlanetCreationRequest;
import com.mvc.request.PlanetFilterRequest;
import com.mvc.responce.PlanetResponse;
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
        } else if (request.getPopulation()<= 0) {
            throw new PlanetServiceException("Rozmiar planety min. 1");
        }

        PlanetType type = PlanetType.valueOf(request.getType());
        //klasa request spełniła swoje zadanie, przyprowadziła nam to dane z formularza
        //na ich bazie budujemy obiekt który zaprojektuje tabele dla tych danych
        //PlanetCreationRequest -> odpowiada za wprowadzane dane o planecie i oddaje strukture formularza
        //StarWarsPlanetResponse -> odpowiada za pobrane dane o planecie i oddaje strukture jsona
        //Planet -> odpowiada za dane przechowywane planety i oddaje strukture tabeli
        Planet planet = new Planet(request.getName(), type, request.getPopulation());
        repository.save(planet);
    }

    public List<PlanetResponse> getAllPlanets() {
       return repository.findAll().stream()
                .map(p -> new PlanetResponse(p.getName(), p.getType(), p.getPopulation()))
                .toList();
    }

    public List<PlanetResponse> getPlanets(PlanetFilterRequest filterRequest) {
        PlanetType type = PlanetType.valueOf(filterRequest.getPlanetType());
        return repository.findByType(type).stream()
                .map(p -> new PlanetResponse(p.getName(), p.getType(), p.getPopulation()))
                .toList();
    }
}
