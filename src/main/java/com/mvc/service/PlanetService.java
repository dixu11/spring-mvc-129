package com.mvc.service;

import com.mvc.entity.Imperator;
import com.mvc.entity.Planet;
import com.mvc.entity.PlanetType;
import com.mvc.exception.PlanetServiceException;
import com.mvc.repository.ImperatorRepository;
import com.mvc.repository.PlanetRepository;
import com.mvc.request.PlanetCreationRequest;
import com.mvc.request.PlanetFilterRequest;
import com.mvc.responce.PlanetResponse;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlanetService {
    private PlanetRepository planetRepository;
    private ImperatorRepository imperatorRepository;

    public PlanetService(PlanetRepository planetRepository, ImperatorRepository imperatorRepository) {
        this.planetRepository = planetRepository;
        this.imperatorRepository = imperatorRepository;
    }


    //METODA DO PRZETESTOWANIA REMOVE PLANET - remove ArrayListy nie zadziała poprawnie bez equals + hashcode
    //jeśli domyślne LazyLoading sprawia problemy możemy rozważyć przestawienie relacji na Eager
   // @PostConstruct
   // @Transactional
    public void removePlanet() {
        Imperator imperator = imperatorRepository.findById("test").orElseThrow();
        Planet planet = planetRepository.findById(62L).orElseThrow();
        imperator.removePlanet(planet);
        planetRepository.save(planet);
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

        //planeta zostaje przypisana do imperatora
        //wyciągamy zalogowanego imperatora
        Imperator imperator = imperatorRepository.findById("test").orElseThrow();
        imperator.addPlanet(planet);
        planetRepository.save(planet);
        imperatorRepository.save(imperator);
    }

    public List<PlanetResponse> getAllPlanets() {
       return planetRepository.findAll().stream()
                .map(p -> new PlanetResponse(p.getName(), p.getType(), p.getPopulation()))
                .toList();
    }

    public List<PlanetResponse> getPlanets(PlanetFilterRequest filterRequest) {
        PlanetType type = PlanetType.valueOf(filterRequest.getPlanetType());
        return planetRepository.findByType(type).stream()
                .map(p -> new PlanetResponse(p.getName(), p.getType(), p.getPopulation()))
                .toList();
    }


    public List<PlanetResponse> getTop3PopulatedPlanets() {
//        List<Planet> planets = repository.findTop3ByOrderByPopulationDesc();
//        List<Planet> planets = repository.findTop3();
        List<Planet> planets = planetRepository.findTop3OnEntityManager();
        //z bazy danych dostajemy obiekty Planet - które przechowują dane z tabeli SQL

        //nie wszystkie z tych danych są potrzebne w HTML, przygotujemy więc na ich bazie obiekty reprezentujace
        //planety w kontekście widoku html - PlanetResponse
        //zachowujemy również dzięki temu wyraźną granicę architektoniczną:
        // w serwisach używamy encji bazodanowych
        // w controllerach używamy obiektów Request i Responce i nie mamy kontaktu ze strukturą bazy

        List<PlanetResponse> planetsResponse = new ArrayList<>();
        for (Planet planet : planets) {
            PlanetResponse planetResponse = new PlanetResponse(planet.getName(), planet.getType(), planet.getPopulation());
            planetsResponse.add(planetResponse);
        }

        return planetsResponse;

    }
}
