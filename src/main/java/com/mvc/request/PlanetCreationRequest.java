package com.mvc.request;

public class PlanetCreationRequest {

    private String name;
    private String type;
    private long population;

    public PlanetCreationRequest(String name, String type, long population) {
        this.name = name;
        this.type = type;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public long getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "PlanetCreationRequest{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size=" + population +
                '}';
    }
}
