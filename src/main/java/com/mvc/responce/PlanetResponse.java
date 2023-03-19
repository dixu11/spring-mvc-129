package com.mvc.responce;

import com.mvc.entity.PlanetType;

import java.util.Objects;

public class PlanetResponse {
    private String name;
    private PlanetType type;
    private int size;

    public PlanetResponse(String name, PlanetType type, int size) {
        this.name = name;
        this.type = type;
        this.size = size;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetResponse that = (PlanetResponse) o;
        return size == that.size && Objects.equals(name, that.name) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, size);
    }

    @Override
    public String toString() {
        return "PlanetResponse{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", size=" + size +
                '}';
    }
}
