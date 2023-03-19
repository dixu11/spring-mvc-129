package com.mvc.responce;

import com.mvc.entity.PlanetType;

import java.util.Objects;

public class PlanetResponse {
    private String name;
    private PlanetType type;
    private long population;

    public PlanetResponse(String name, PlanetType type, long population) {
        this.name = name;
        this.type = type;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public PlanetType getType() {
        return type;
    }

    public long getPopulation() {
        return population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetResponse that = (PlanetResponse) o;
        return population == that.population && Objects.equals(name, that.name) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, population);
    }

    @Override
    public String toString() {
        return "PlanetResponse{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", population=" + population +
                '}';
    }
}
