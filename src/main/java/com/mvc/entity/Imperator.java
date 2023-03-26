package com.mvc.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "imperators")
public class Imperator {
    @Id
    private String name;
    private String password; //todo hashowanie hasła
    private int credits = 10_000;
    @OneToMany(mappedBy = "imperator",fetch = FetchType.EAGER)
    private List<Planet> planets = new ArrayList<>();

    public Imperator(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Imperator() {
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
        planet.setImperator(this);
    }

    public void removePlanet(Planet planet) {
        planets.remove(planet);
        planet.setImperator(null);
        //należy upewnić się że planeta już nie wskazuje na imperatora bo to to buduje relacje bazodanową
        //a nie informacja że coś jest w liście -> ze względu na mappedBy
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imperator imperator = (Imperator) o;
        return credits == imperator.credits && Objects.equals(name, imperator.name) && Objects.equals(password, imperator.password) && Objects.equals(planets, imperator.planets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, credits, planets);
    }

    public String getPassword() {
        return password;
    }
}
