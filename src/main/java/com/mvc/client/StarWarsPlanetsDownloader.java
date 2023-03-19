package com.mvc.client;

import com.mvc.repository.PlanetRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StarWarsPlanetsDownloader {

    private static final String URL = "https://swapi.dev/api/planets";

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
        //getForObject zrobi zapytanie do api i jeszcze skonwertuje rezultat do obiektu wskazanej klasy
        StarWarsPlanetsResponse response = template.getForObject(URL, StarWarsPlanetsResponse.class);
    }
}
