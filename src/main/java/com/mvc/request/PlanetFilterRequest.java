package com.mvc.request;

import java.util.Objects;

public class PlanetFilterRequest {
    private String planetType;

    public String getPlanetType() {
        return planetType;
    }

    public void setPlanetType(String planetType) {
        this.planetType = planetType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetFilterRequest that = (PlanetFilterRequest) o;
        return Objects.equals(planetType, that.planetType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planetType);
    }

    @Override
    public String toString() {
        return "PlanetFilterRequest{" +
                "planetType='" + planetType + '\'' +
                '}';
    }
}
