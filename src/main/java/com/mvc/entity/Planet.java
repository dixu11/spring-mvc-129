package com.mvc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import  org.hibernate.annotations.CascadeType;

import java.util.Objects;

@Entity
@Table(name = "planets")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    @Enumerated(value = EnumType.STRING)
    private PlanetType type;
    private long population;
    @OneToOne
    @Cascade(CascadeType.ALL) //powoduje że wszystkie operacje na Planet są transferowane na Port np. save, delete, update...
    private Port port = null;
    @ManyToOne
    @JoinColumn(name = "imperator_id")
    private Imperator imperator;

    public Planet(String name, PlanetType type, long population) {
        this.name = name;
        this.type = type;
        this.population = population;
    }

    public Planet() {
    }

    public void setImperator(Imperator imperator) {
        this.imperator = imperator;
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

    public void setPort(Port port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return id == planet.id && population == planet.population && Objects.equals(name, planet.name) && type == planet.type && Objects.equals(port, planet.port) && Objects.equals(imperator, planet.imperator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, population, port, imperator);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", population=" + population +
                '}';
    }
}
