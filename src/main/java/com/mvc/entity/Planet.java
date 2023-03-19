package com.mvc.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "planets")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private PlanetType type;
    private int size;

    public Planet(String name, PlanetType type, int size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public Planet() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return id == planet.id && size == planet.size && Objects.equals(name, planet.name) && type == planet.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, size);
    }

    public String getName() {
        return name;
    }

    public PlanetType getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", size=" + size +
                '}';
    }
}
