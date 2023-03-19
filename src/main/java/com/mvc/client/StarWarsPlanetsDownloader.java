package com.mvc.client;

import com.mvc.entity.Planet;
import com.mvc.entity.PlanetType;
import com.mvc.repository.PlanetRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class StarWarsPlanetsDownloader {

    private static final String URL = "https://swapi.dev/api/planets/?page=%d";
    private PlanetRepository repository;
    private RestTemplate template; //obiekt z biblioteki Spring do robienia zapytań http

    public StarWarsPlanetsDownloader(PlanetRepository repository, RestTemplate template) {
        this.repository = repository;
        this.template = template;
    }

    @PostConstruct
    public void download() {
        if (repository.count() > 0) {
            return;
        }

        for (int i = 0; i < 6; i++) {
            int pageNumber = i + 1;
            Thread thread = new Thread(()->downloadPage(pageNumber));
            thread.start();
        }

    }

    private void downloadPage(int page) {
        //getForObject zrobi zapytanie do api i jeszcze skonwertuje rezultat do obiektu wskazanej klasy
        StarWarsPlanetsResponse response = template.getForObject(String.format(URL,page), StarWarsPlanetsResponse.class);
        List<Planet> planets = new ArrayList<>();
        for (StarWarsPlanetResponse swPlanet : response.getResults()) {
            Planet planet = new Planet(
                    swPlanet.getName(),
                    PlanetType.ROCK,
                    swPlanet.getPopulation()
            );
            planets.add(planet);
        }
        repository.saveAll(planets);
    }
}
