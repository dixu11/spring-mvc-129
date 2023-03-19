package com.mvc.client;

public class StarWarsPlanetResponse {
    private String name;
    private String population;

    //gettery i bezparametrowy konstruktor wymagane przez bibliotekę parsującą JSON (Jackson)
    public StarWarsPlanetResponse() {
    }

    public String getName() {
        return name;
    }

    public String getPopulation() {
        return population;
    }
}
