package com.mvc.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "imperators")
public class Imperator {
    @Id
    private String name;
    private String password; //todo hashowanie hasła
    private int credits = 10_000;
    @OneToMany(mappedBy = "imperator")
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
        planets.remove(planet); //todo problemy???
    }
}
